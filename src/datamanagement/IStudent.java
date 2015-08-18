package datamanagement;

public interface IStudent {

  public Integer getStudentId();

  public String getFirstName();
  public void setFirstName(String firstName);

  public String getLastName();
  public void setLastName(String lastName);

  public void addStudentUnitRecord( IStudentUnitRecord record );
  public IStudentUnitRecord retrieveStudentUnitRecord( String unitCode );

  public StudentUnitRecordList retrieveAllStudentUnitRecords();

}
