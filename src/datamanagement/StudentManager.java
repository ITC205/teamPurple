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
  
  public static StudentManager getInstance() 
  {
    if (instance_ == null) {
      instance_ = new StudentManager(); 
    }
    return instance_; 
  }

  
  // Create new student or return existing student
  public IStudent getStudent(Integer studentId) 
  {
    IStudent student = studentMap_.get(studentId);
    
    return student != null ? student : createStudent(studentId);
  }
  

  //===========================================================================
  // Methods: primary
  //===========================================================================
  
  // Create new student
  private IStudent createStudent(Integer studentId) 
  {
    IStudent student;
    Element studentElement = getStudentElement(studentId);
    
    if (studentElement != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance()
                                           .getRecordsByStudent(studentId);
      Integer newStudentId = new Integer(studentElement
                                           .getAttributeValue("sid"));
      String newFirstName = studentElement.getAttributeValue("fname");
      String newLastName = studentElement.getAttributeValue("lname");
      
      student = new Student(newStudentId,newFirstName,newLastName,recordList);
      
      studentMap_.put(student.getStudentId(), student);
      
      return student; 
    } //  End if
    
    throw new RuntimeException("DBMD: createStudent: Student not in file");
  }

  
  // Create new student proxy
  private IStudent createStudentProxy(Integer studentId) 
  {
    Element studentElement = getStudentElement(studentId);
    String newFirstName = studentElement.getAttributeValue("fname");
    String newLastName = studentElement.getAttributeValue("lname");

    if (getStudentElement(studentId) != null) {
      return new StudentProxy(studentId, newFirstName, newLastName);
    }
    throw new RuntimeException("StudentManager: createStudentProxy: Student not in file");
  }

  
  // Return students studying unitCode
  public StudentMap getStudentsByUnit(String unitCode) 
  {
    StudentMap studentMapByUnit = unitMap_.get(unitCode);
    
    if (studentMapByUnit != null) {
      return studentMapByUnit;
    }
    
    studentMapByUnit = new StudentMap();
    IStudent student;
    StudentUnitRecordList allStudentUnitRecords = StudentUnitRecordManager
                                                   .instance()
                                                   .getRecordsByUnit(unitCode);
   
    for (IStudentUnitRecord studentUnitRecord : allStudentUnitRecords) {
      Integer studentId = studentUnitRecord.getStudentId();
      student = createStudentProxy(studentId);
      studentMapByUnit.put(student.getStudentId(), student);
    }
    
    unitMap_.put(unitCode, studentMapByUnit);
    return studentMapByUnit;
  }
  
  
  
  // Get student record from XML file
  private Element getStudentElement(Integer studentId) 
  {
    for (Element studentDetails : (List<Element>) XMLManager.getXML()
                                                      .getDocument()
                                                      .getRootElement()
                                                      .getChild("studentTable")
                                                      .getChildren("student")) 
    {
      Integer savedStudentId = new Integer(studentDetails
                                           .getAttributeValue("sid"));
      if (studentId.toString().equals(savedStudentId))
      {
        return studentDetails;
      }
    }
    
    return null;
  }
  
  

}
