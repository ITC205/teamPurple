package datamanagement;

public class Student implements IStudent 
{
  private Integer studentId; 
  private String firstName;
  private String ln;
  private StudentUnitRecordList su;

  public Student( Integer studentId, String firstName, String ln, StudentUnitRecordList su ) 
  { 
    this.studentId = studentId; 
    this.firstName = firstName;
    this.ln = ln;
    this.su = su == null ? new StudentUnitRecordList() : su;
  }

  public Integer getID() 
  { 
    return this.studentId; 
  } 

  public String getFirstName() 
  { 
    return firstName; 
  }

  public void setFirstName( String firstName ) 
  { 
    this.firstName = firstName;
  }

  public String getLastName() 
  { 
    return ln;
  }

  public void setLastName( String lastName ) 
  { 
    this.ln = lastName; 
  }

  public void addUnitRecord( IStudentUnitRecord record ) 
  { 
    su.add(record); 
  }

  public IStudentUnitRecord getUnitRecord( String unitCode ) 
  {
    for ( IStudentUnitRecord r : su ) 
      if ( r.getUnitCode().equals(unitCode)) 
        return r; 
    return null;   
  }

  public StudentUnitRecordList getUnitRecords() 
  { 
    return su; 
  }
}
