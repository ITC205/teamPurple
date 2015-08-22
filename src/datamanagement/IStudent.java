package datamanagement;

public interface IStudent
{
  
  public Integer getStudentId();
  
  
  
  public String getFirstName();
  
  
  
  public String getLastName();

  
  
  public void setFirstName(String firstName);
  
  
  
  public void setLastName(String lastName);
  
  
  
  public StudentUnitRecordList retrieveAllStudentUnitRecords();

  
  
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord);
  
  
  
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode);
  
}
