package datamanagement;



public interface IStudent
{
  
  public Integer getStudentId();
  public String getFirstName();
  public String getLastName();
  public StudentUnitRecordList getStudentUnitRecords();

  public void setFirstName(String firstName);
  public void setLastName(String lastName);

  public void addStudentUnitRecord(IStudentUnitRecord record);
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode);
  
}
