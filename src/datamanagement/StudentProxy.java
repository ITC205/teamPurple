package datamanagement;


public class StudentProxy implements IStudent 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private Integer studentId_;
  private String firstName_;
  private String lastName_;
  private StudentManager allStudents_;

  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  public StudentProxy(Integer studentId, String firstName, String lastName) 
  {
    studentId_ = studentId;
    firstName_ = firstName;
    lastName_ = lastName;
    allStudents_ = StudentManager.getInstance();
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
    allStudents_.getStudent(studentId_).setFirstName(firstName);
  }

  
  
  public void setLastName(String lastName) 
  {
    allStudents_.getStudent(studentId_).setLastName(lastName);
  }

  
  
  public void addStudentUnitRecord(IStudentUnitRecord record) 
  {
    allStudents_.getStudent(studentId_).addStudentUnitRecord(record);
  }
  
  
  
  //===========================================================================
  // Methods: primary
  //===========================================================================
  
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode) 
  {
    return allStudents_.getStudent(studentId_).retrieveStudentUnitRecord(unitCode);
  }
  
  
  
  public StudentUnitRecordList retrieveAllStudentUnitRecords() 
  { 
    return allStudents_.getStudent(studentId_).retrieveAllStudentUnitRecords();
  }
}




