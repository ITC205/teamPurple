package datamanagement;

import org.jdom.*;

import java.util.List;
import java.util.HashMap;



public class StudentManager 
{
  
  private static StudentManager self = null;

  private StudentMap studentMap_;
  private HashMap<String, StudentMap> unitMap_;

  
  
  public static StudentManager get() 
  {
    if (self == null) {
      self = new StudentManager(); 
    }
    return self; 
  }

  
  
  private StudentManager() 
  {
    studentMap_ = new StudentMap();
    unitMap_ = new HashMap<>();
  }

  
  
  public IStudent getStudent(Integer studentId) 
  {
    IStudent student = studentMap_.get(studentId);
    
    return student != null ? student : createStudent(studentId);
  }

  
  
  private Element getStudentElement(Integer studentId) 
  {
    for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
      if (studentId.toString().equals(el.getAttributeValue("sid"))) {
        return el;
      }
    
    return null;
  }

  
  
  private IStudent createStudent(Integer studentId) 
  {
    IStudent student;
    Element el = getStudentElement(studentId);
    
    if (el != null) {
      StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager.instance().getRecordsByStudent(studentId);
      student = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),studentUnitRecordList);
      studentMap_.put(student.getID(), student);
      return student; 
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  
  
  private IStudent createStudentProxy(Integer studentId) 
  {
    Element el = getStudentElement(studentId);

    if (el != null) {
      return new StudentProxy(studentId, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
    }
    
    throw new RuntimeException("DBMD: createStudent : student not in file");
  }

  
  
  public StudentMap getStudentsByUnit(String unitCode) 
  {
    StudentMap studentMapByUnit = unitMap_.get(unitCode);
    
    if (studentMapByUnit != null) {
      return studentMapByUnit;
    }
    
    studentMapByUnit = new StudentMap();
    IStudent student;
    StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager.instance().getRecordsByUnit(unitCode);
   
    for (IStudentUnitRecord studentUnitRecord : studentUnitRecordList) {
      student = createStudentProxy(new Integer(studentUnitRecord.getStudentID()));
      studentMapByUnit.put(student.getID(), student);
    }
    
    unitMap_.put( unitCode, studentMapByUnit);
    return studentMapByUnit;
  }
  
  
  
}
