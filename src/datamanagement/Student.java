package datamanagement;

public class Student implements IStudent 
{
  
  private Integer studentId_; 
  private String firstName_;
  private String lastName_;
  private StudentUnitRecordList studentUnitRecordList_;

  
  
  public Student( Integer studentId, String firstName, String lastName, StudentUnitRecordList studentUnitRecordList ) 
  { 
    studentId_ = studentId; 
    firstName_ = firstName;
    lastName_ = lastName;
    studentUnitRecordList_ = studentUnitRecordList == null ? new StudentUnitRecordList() : studentUnitRecordList;
  }

  
  
  public Integer getID() 
  { 
    return this.studentId_; 
  } 

  
  
  public String getFirstName() 
  { 
    return firstName_; 
  }
  
  
  
  public String getLastName() 
  { 
    return lastName_;
  }

  
  
  public StudentUnitRecordList getUnitRecords() 
  { 
    return studentUnitRecordList_; 
  }

  
  
  public void setFirstName( String firstName ) 
  { 
    this.firstName_ = firstName;
  }

  
  
  public void setLastName( String lastName ) 
  { 
    this.lastName_ = lastName; 
  }

  
  
  public void addUnitRecord( IStudentUnitRecord record ) 
  { 
    studentUnitRecordList_.add(record); 
  }

  
  
  public IStudentUnitRecord getUnitRecord( String unitCode ) 
  {
    for ( IStudentUnitRecord record : studentUnitRecordList_ ) {
      if ( record.getUnitCode().equals(unitCode)) {
        return record; 
      }
    }
    return null;   
  }
  
  
  
}
