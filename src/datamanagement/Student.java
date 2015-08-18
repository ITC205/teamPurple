package datamanagement;

public class Student implements IStudent {
  private Integer studentId; private String studentFirstName;
  private String studentLastName;
  private StudentUnitRecordList su;

  public Student( Integer studentId, String studentFirstName, String studentLastName, StudentUnitRecordList su ) 
  { this.studentId = studentId; this.studentFirstName = studentFirstName;
  this.studentLastName = studentLastName;this.su = 
      su == null ? new StudentUnitRecordList() : 
        su;
  }

  public Integer getStudentId() { return this.studentId; 
  } public String getFirstName() { 
    return studentFirstName; }

  public void setFirstName( String firstName ) { 
    this.studentFirstName = firstName; }

  public String getLastName() { 
    return studentLastName; }
  public void setLastName( String studentLastName ) { 


    this.studentLastName = studentLastName; }

  public void addStudentUnitRecord( IStudentUnitRecord record ) { su.add(record); }
  public IStudentUnitRecord retrieveStudentUnitRecord( String unitCode ) {
    for ( IStudentUnitRecord r : su ) 
      if ( r.getUnitCode().equals(unitCode)) 
        return r; 

    return null;

  }

  public StudentUnitRecordList retrieveAllStudentUnitRecords() { return su; }}
