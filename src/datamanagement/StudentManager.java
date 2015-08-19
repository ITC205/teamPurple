package datamanagement;

import org.jdom.*;

import java.util.List;
import java.util.HashMap;



public class StudentManager 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private static StudentManager instance_ = null;

  private StudentMap studentMap_;
  private HashMap<String, StudentMap> unitMap_;

  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  private StudentManager() 
  {
    studentMap_ = new StudentMap();
    unitMap_ = new HashMap<>();
  }

  
  //===========================================================================
  // Getters and Setters
  //===========================================================================
  
  //Singleton class. Use getInstance
  public static StudentManager getInstance() 
  {
    if (instance_ == null) {
      instance_ = new StudentManager(); 
    }
    return instance_; 
  }
  
  
  //===========================================================================
  // Methods
  //===========================================================================
  
  // Create new student or return existing student
  public IStudent findStudent(Integer studentId) 
  {
    IStudent student = studentMap_.get(studentId);
    
    if (student == null) {
      return createStudent(studentId);
    }
    else {
      return student;
    }
  }

  
  
  // Get student record from XML file
  private Element getStudentElement(Integer studentId) 
  {
    for (Element studentElement : (List<Element>) XMLManager.getInstance()
                                     .getDocument().getRootElement()
                                     .getChild("studentTable")
                                     .getChildren("student")) 
    {
      if (studentId.toString().equals(studentElement.getAttributeValue("sid")))
      {
        return studentElement;
      }
    }
    return null;
  }

  

  // Create new student
  private IStudent createStudent(Integer studentId) 
  {
    IStudent student;
    Element studentElement = getStudentElement(studentId);
    
    if (studentElement != null) {
      StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager
                         .getInstance().findUnitRecordsByStudent(studentId);
      student = new Student(new Integer(studentElement
                         .getAttributeValue("sid")),studentElement
                         .getAttributeValue("fname"),studentElement
                         .getAttributeValue("lname"),studentUnitRecordList);
      studentMap_.put(student.getStudentId(), student);
      return student; 
    }
    
    throw new RuntimeException("StudentManager: createStudent"
                          + " : student not in file");
  }

  
  // Create new student proxy
  private IStudent createStudentProxy(Integer studentId) 
  {
    Element studentElement = getStudentElement(studentId);

    if (studentElement != null) {
      return new StudentProxy(studentId, studentElement
                           .getAttributeValue("fname"), studentElement
                           .getAttributeValue("lname"));
    }
    
    throw new RuntimeException("StudentManager: createStudentProxy"
                           + " : student not in file");
  }
  
  
  
   // Return students studying unitCode
  public StudentMap findStudentsByUnit(String unitCode) 
  {
    StudentMap studentMapByUnit = unitMap_.get(unitCode);
    
    if (studentMapByUnit != null) {
      return studentMapByUnit;
    }
    
    studentMapByUnit = new StudentMap();
    IStudent student;
    StudentUnitRecordList studentUnitRecordList = StudentUnitRecordManager.getInstance().findStudentRecordsByUnit(unitCode);
   
    for (IStudentUnitRecord studentUnitRecord : studentUnitRecordList) {
      student = createStudentProxy(new Integer(studentUnitRecord.getStudentId()));
      studentMapByUnit.put(student.getStudentId(), student);
    }
    
    unitMap_.put( unitCode, studentMapByUnit);
    return studentMapByUnit;
  }
  
  
  
}
