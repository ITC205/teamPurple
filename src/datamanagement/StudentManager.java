package datamanagement;

import java.util.List;
import java.util.HashMap;

import org.jdom.Element;

public class StudentManager 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  
  
  private static StudentManager instance_ = null;

  private StudentMap allStudentsMap_;
  private HashMap<String, StudentMap> studentsByUnitMap_;

  
  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  
  
  private StudentManager() 
  {
    allStudentsMap_ = new StudentMap();
    studentsByUnitMap_ = new HashMap<>();
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
  
  
  
  //===========================================================================
  // Methods
  //===========================================================================
  
  
  
  // Create new student or return existing student
  public IStudent findStudent(Integer studentId) 
  {
    IStudent student = allStudentsMap_.get(studentId);
    
    if (student == null) {
      return loadStudent(studentId);
    }
    else {
      return student;
    }
  }

  
  
  // Get student record from XML file
  private Element retrieveStudentElement(Integer studentId) 
  {
    for (Element studentElement : (DataManager.getInstance()
                                              .retrieveAllStudentElements()))
    {
      if (studentId.toString().equals(studentElement.getAttributeValue("sid")))
      {
        return studentElement;
      }
    }
    return null;
  }



  // Retrieve student from XML file and create new student instance
  private IStudent loadStudent(Integer studentId) 
  {
    IStudent student;
    Element studentElement = retrieveStudentElement(studentId);
    
    if (studentElement != null) {
      StudentUnitRecordList unitRecordsByStudent = StudentUnitRecordManager
                            .getInstance()
                            .findUnitRecordsByStudent(studentId);
      student = new Student(new Integer(studentElement
                            .getAttributeValue("sid")),studentElement
                            .getAttributeValue("fname"),studentElement
                            .getAttributeValue("lname"),unitRecordsByStudent);
      allStudentsMap_.put(student.getStudentId(), student);
      return student; 
    }
    
    throw new RuntimeException("StudentManager : createStudent" +
                               " : student not in file");
  }

  
  
  // Create new student proxy
  private IStudent createStudentProxy(Integer studentId) 
  {
    Element studentElement = retrieveStudentElement(studentId);

    if (studentElement != null) {
      return new StudentProxy(studentId, studentElement
                              .getAttributeValue("fname"), studentElement
                              .getAttributeValue("lname"));
    }
    
    throw new RuntimeException("StudentManager : createStudentProxy" +
                               " : student not in file");
  }
  
  
  
  // Return students studying unitCode
  public StudentMap findStudentsByUnit(String unitCode) 
  {
    StudentMap studentsInUnit = studentsByUnitMap_.get(unitCode);
    
    if (studentsInUnit != null) {
      return studentsInUnit;
    }
    
    studentsInUnit = new StudentMap();
    IStudent student;
    StudentUnitRecordList studentRecordsByUnit = StudentUnitRecordManager
                          .getInstance()
                          .findStudentRecordsByUnit(unitCode);
   
    for (IStudentUnitRecord studentUnitRecord : studentRecordsByUnit) {
      student = createStudentProxy(new Integer(studentUnitRecord
                                               .getStudentId()));
      studentsInUnit.put(student.getStudentId(), student);
    }
    
    studentsByUnitMap_.put( unitCode, studentsInUnit);
    return studentsInUnit;
  }
   
}
