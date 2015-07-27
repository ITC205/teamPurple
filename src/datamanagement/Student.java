package datamanagement;

public class Student implements IStudent {
  private Integer studentId; private String studentFirstName;
  private String ln;
  private StudentUnitRecordList su;

  public Student( Integer id, String studentFirstName, String ln, StudentUnitRecordList su ) { this.studentId = id; this.studentFirstName = studentFirstName;
  this.ln = ln;this.su = 
      su == null ? new StudentUnitRecordList() : 
        su;
  }

  public Integer getID() { return this.studentId; 
  } public String getFirstName() { 
    return studentFirstName; }

  public void setFirstName( String firstName ) { 
    this.studentFirstName = firstName; }

  public String getLastName() { 
    return ln; }
  public void setLastName( String lastName ) { 


    this.ln = lastName; }

  public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
  public IStudentUnitRecord getUnitRecord( String unitCode ) {
    for ( IStudentUnitRecord r : su ) 
      if ( r.getUnitCode().equals(unitCode)) 
        return r; 

    return null;

  }

  public StudentUnitRecordList getUnitRecords() { return su; }}
