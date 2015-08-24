<<<<<<< HEAD
package datamanagement;

public class StudentProxy 
  implements IStudent 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  
  
  private Integer studentId_;
  private String firstName_;
  private String lastName_;
  private StudentManager studentManager_;

  
  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  
  
  public StudentProxy(Integer studentId, String firstName, String lastName) 
  {
    studentId_ = studentId;
    firstName_ = firstName;
    lastName_ = lastName;
    studentManager_ = StudentManager.getInstance();
  }


  
  //===========================================================================
  // Getters and Setters
  //===========================================================================
  
  
  
  public Integer getStudentId() 
  { 
    return studentId_; 
  }

  
  
  public String getFirstName() 
  { 
    return firstName_; 
  }

  
  
  public String getLastName() 
  { 
    return lastName_; 
  }

  
  
  public void setFirstName(String firstName) 
  {
    studentManager_.findStudent(studentId_).setFirstName(firstName);
  }

  
  
  public void setLastName(String lastName) 
  {
    studentManager_.findStudent(studentId_).setLastName(lastName);
  }
  
  
  
  //===========================================================================
  // Methods
  //===========================================================================
  
  
  
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode) 
  {
    return studentManager_.findStudent(studentId_)
                          .retrieveStudentUnitRecord(unitCode);
  }
  
  
  
  public void addStudentUnitRecord(IStudentUnitRecord record) 
  {
    studentManager_.findStudent(studentId_).addStudentUnitRecord(record);
  }
  
  
  
  public StudentUnitRecordList retrieveAllStudentUnitRecords() 
  { 
    return studentManager_.findStudent(studentId_)
                          .retrieveAllStudentUnitRecords();
  }

}
