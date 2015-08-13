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
  // Methods: primary
  //===========================================================================
  
  /**
   * create new student
   */
  private IStudent createStudent(Integer studentId) 
  {
    IStudent student;
    Element studentDetails = getStudentElement(studentId);
    
    if (studentDetails != null) {
      StudentUnitRecordList recordList = StudentUnitRecordManager.instance()
                                           .getRecordsByStudent(studentId);
      Integer newStudentId = new Integer(studentDetails
                                           .getAttributeValue("sid"));
      String newFirstName = studentDetails.getAttributeValue("fname");
      String newLastName = studentDetails.getAttributeValue("lname");
      
      student = new Student(newStudentId,newFirstName,newLastName,recordList);
      
      studentMap_.put(student.getID(), student);
      
      return student; 
    } //  End if
    
    throw new RuntimeException("DBMD: createStudent: Student not in file");
  }

  
  /**
   * create new student proxy
   */
  private IStudent createStudentProxy(Integer studentId) 
  {
    Element studentDetails = getStudentElement(studentId);
    String newFirstName = studentDetails.getAttributeValue("fname");
    String newLastName = studentDetails.getAttributeValue("lname");

    if (getStudentElement(studentId) != null) {
      return new StudentProxy(studentId, newFirstName, newLastName);
    }
    throw new RuntimeException("StudentManager: createStudentProxy: Student not in file");
  }

  
  /**
   * return students studying unitCode
   */
  public StudentMap getStudentsByUnit(String unitCode) 
  {
    StudentMap studentMapByUnit = unitMap_.get(unitCode);
    
    if (studentMapByUnit != null) {
      return studentMapByUnit;
    }
    
    studentMapByUnit = new StudentMap();
    IStudent student;
    StudentUnitRecordList recordList = StudentUnitRecordManager.instance()
                                                   .getRecordsByUnit(unitCode);
   
    for (IStudentUnitRecord studentUnitRecord : recordList) {
      Integer studentId = studentUnitRecord.getStudentID();
      student = createStudentProxy(studentId);
      studentMapByUnit.put(student.getID(), student);
    }
    
    unitMap_.put(unitCode, studentMapByUnit);
    return studentMapByUnit;
  }
  
  
  
  /**
   * get student record from XML file
   */
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

  
  /**
   * create new student or return existing student
   */
  public IStudent getStudent(Integer studentId) 
  {
    IStudent student = studentMap_.get(studentId);
    
    return student != null ? student : createStudent(studentId);
  }
  
  
  
}
