package datamanagement;

public class StudentProxy implements IStudent {
  private Integer id;
  private String firstName;
  private String lastName;
  private StudentManager studentManager;


  public StudentProxy( Integer id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentManager = StudentManager.get();}


  public Integer getID() {
    return this.id;
  }


  public String getFirstName() {
    return firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setFirstName(String firstName) {
    studentManager.getStudent(id).setFirstName(firstName);
  }


  public void setLastName(String lastName) {
    studentManager.getStudent(id).setLastName(lastName);
  }


  public void addUnitRecord(IStudentUnitRecord record) {
    studentManager.getStudent(id).addUnitRecord(record);
  }


  public IStudentUnitRecord getUnitRecord(String unitCode) {
    return studentManager.getStudent(id).getUnitRecord(unitCode);
  }


  public StudentUnitRecordList getUnitRecords() {
    return studentManager.getStudent(id).getUnitRecords();
  }


}