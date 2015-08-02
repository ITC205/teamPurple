package datamanagement;

public class Student implements IStudent 
{
  private Integer studentId; 
  private String firstName;
  private String lastName;
  private StudentUnitRecordList studentUnitRecordList;

  public Student( Integer studentId, String firstName, String lastName, StudentUnitRecordList su ) 
  { 
    this.studentId = studentId; 
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentUnitRecordList = su == null ? new StudentUnitRecordList() : su;
  }

  public Integer getID() 
  { 
    return this.studentId; 
  } 

  public String getFirstName() 
  { 
    return firstName; 
  }
  
  public String getLastName() 
  { 
    return lastName;
  }

  public void setFirstName( String firstName ) 
  { 
    this.firstName = firstName;
  }

  public void setLastName( String lastName ) 
  { 
    this.lastName = lastName; 
  }

  public void addUnitRecord( IStudentUnitRecord record ) 
  { 
    studentUnitRecordList.add(record); 
  }

  public IStudentUnitRecord getUnitRecord( String unitCode ) 
  {
    for ( IStudentUnitRecord record : studentUnitRecordList ) 
      if ( record.getUnitCode().equals(unitCode)) 
        return record; 
    return null;   
  }

  public StudentUnitRecordList getUnitRecords() 
  { 
    return studentUnitRecordList; 
  }
}
