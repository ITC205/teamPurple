package datamanagement;

public class Student implements IStudent 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private Integer studentId_; 
  private String firstName_;
  private String lastName_;
  private StudentUnitRecordList recordList_;

  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  public Student(Integer studentId, String firstName, String lastName
                                   , StudentUnitRecordList recordList)
  { 
    studentId_ = studentId; 
    firstName_ = firstName;
    lastName_ = lastName;
    recordList_ = recordList == null ? new StudentUnitRecordList() : recordList;
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

  
  
  public StudentUnitRecordList getStudentUnitRecords() 
  { 
    return recordList_; 
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
  
  public void addStudentUnitRecord(IStudentUnitRecord record) 
  { 
    recordList_.add(record); 
  }

  

  // Return student unit record for unitCode
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode) 
  {
    for (IStudentUnitRecord record : recordList_) {
      if (record.getUnitCode().equals(unitCode)) {
        return record; 
      }
    }
    return null;   
  }
  
  

}
