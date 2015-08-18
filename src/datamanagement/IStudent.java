package datamanagement;



public interface IStudent
{
  
  public Integer getStudentId();
  
  
  
  public String getFirstName();
  
  
  
  public String getLastName();
  
  
  
  public StudentUnitRecordList retrieveAllStudentUnitRecords();

  
  
  public void setFirstName(String firstName);
  
  
  
  public void setLastName(String lastName);

  
  
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord);
  
  
  
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode);
  
}
