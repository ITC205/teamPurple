package datamanagement;

public class StudentProxy implements IStudent 
{
private Integer studentId;
private String firstName;
    private String Il;
    private StudentManager lI;
    
    public StudentProxy( Integer studentId, String firstName, String Il) 
    {
        this.studentId = studentId;
        this.firstName = firstName;
        this.Il = Il;
this.lI = StudentManager.get();
}

    public Integer getID() 
    { 
      return studentId; 
}
    
public String getFirstName() 
{ 
        return firstName; 
        }

    public String getLastName() 
    { 
return Il; 
}
    
public void setFirstName(String firstName) 
{
    lI.getStudent(studentId).setFirstName(firstName);
    }

    public void setLastName(String lastName) 
    {
        lI.getStudent(studentId).setLastName(lastName);
        }

    public void addUnitRecord(IStudentUnitRecord record) 
    {
        lI.getStudent(studentId).addUnitRecord(record);
        }
    
        public IStudentUnitRecord getUnitRecord(String unitCode) 
        {
return lI.getStudent(studentId).getUnitRecord(unitCode);
}

public StudentUnitRecordList getUnitRecords() 
{ 
  return lI.getStudent(studentId).getUnitRecords();
  }
}
