package datamanagement;

public class StudentProxy implements IStudent 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private Integer studentId_;
  private String firstName_;
  private String lastName_;
  private StudentManager studentList_;

  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  public StudentProxy( Integer studentId, String firstName, String lastName) 
  {
    studentId_ = studentId;
    firstName_ = firstName;
    lastName_ = lastName;
    studentList_ = StudentManager.getInstance();
  }

  
  //===========================================================================
  // Instance methods: accessors
  //===========================================================================
  
  public Integer getID() 
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
  
  
  
  public IStudentUnitRecord getUnitRecord(String unitCode) 
  {
    return studentList_.getStudent(studentId_).getUnitRecord(unitCode);
  }
  
  
  
  public StudentUnitRecordList getUnitRecords() 
  { 
    return studentList_.getStudent(studentId_).getUnitRecords();
  }

  
  
  public void setFirstName(String firstName) 
  {
    studentList_.getStudent(studentId_).setFirstName(firstName);
  }

  
  
  public void setLastName(String lastName) 
  {
    studentList_.getStudent(studentId_).setLastName(lastName);
  }

  
  
  public void addUnitRecord(IStudentUnitRecord record) 
  {
    studentList_.getStudent(studentId_).addUnitRecord(record);
  }
  
  
  
}


