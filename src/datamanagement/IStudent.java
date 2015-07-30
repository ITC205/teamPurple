package datamanagement;

public interface IStudent
{
    public Integer getID();
    public String getFirstName();
    public String getLastName();
    public StudentUnitRecordList getUnitRecords();
    
    public void setFirstName(String firstName);
    public void setLastName(String lastName);

    public void addUnitRecord( IStudentUnitRecord record );
    public IStudentUnitRecord getUnitRecord( String unitCode );
}
