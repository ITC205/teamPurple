package datamanagement;

public class Student implements IStudent {

  private Integer id;
  private String firstName;
  private String lastName;
  private StudentUnitRecordList studentUnitRecordList;


public Student( Integer id, String firstName, String lastName,
                StudentUnitRecordList studentUnitRecordList ) {
  this.id = id;
  this.firstName = firstName;
  this.lastName = lastName;
  if (studentUnitRecordList == null) {
    studentUnitRecordList = new StudentUnitRecordList();
  }
  this.studentUnitRecordList = studentUnitRecordList ;
}


  public Integer getID() {
    return this.id;
  }


  public String getFirstName() {
    return this.firstName;
  }


  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return this.lastName;
  }


  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }


  public void addUnitRecord( IStudentUnitRecord record ) {
    studentUnitRecordList.add(record);
  }


  public IStudentUnitRecord getUnitRecord( String unitCode ) {
    for ( IStudentUnitRecord iStudentUnitRecord : studentUnitRecordList )
      if ( iStudentUnitRecord.getUnitCode().equals(unitCode)) {
        return iStudentUnitRecord;
      }
      return null;
  }


  public StudentUnitRecordList getUnitRecords() {
    return studentUnitRecordList;
  }


}
