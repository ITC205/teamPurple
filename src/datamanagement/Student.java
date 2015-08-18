package datamanagement;


public class Student implements IStudent 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private Integer studentId_; 
  private String firstName_;
  private String lastName_;
  private StudentUnitRecordList allStudentUnitRecords_;

  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  public Student(Integer studentId, String firstName, String lastName
                   , StudentUnitRecordList allStudentUnitRecords)
  { 
    studentId_ = studentId; 
    firstName_ = firstName;
    lastName_ = lastName;
    if (allStudentUnitRecords == null) {
      allStudentUnitRecords_ = new StudentUnitRecordList();
    }
    else {
      allStudentUnitRecords_ = allStudentUnitRecords;
    }
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

  
  
  public StudentUnitRecordList retrieveAllStudentUnitRecords() 
  { 
    return allStudentUnitRecords_; 
  }

  
  
  public void setFirstName(String firstName) 
  { 
    firstName_ = firstName;
  }

  
  
  public void setLastName(String lastName) 
  { 
    lastName_ = lastName; 
  }
  
  
  
  //===========================================================================
  // Methods: primary
  //===========================================================================
  
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord) 
  { 
    allStudentUnitRecords_.add(studentUnitRecord); 
  }

  

  // Return student unit record for unitCode
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode) 
  {
    for (IStudentUnitRecord studentUnitRecord : allStudentUnitRecords_) {
      if (studentUnitRecord.getUnitCode().equals(unitCode)) {
        return studentUnitRecord; 
      }
    }
    return null;   
  }
  
  

}
