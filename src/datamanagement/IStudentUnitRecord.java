package datamanagement;

public interface IStudentUnitRecord
{
  
  public Integer getStudentId();



  public String getUnitCode();



  public float getMarkForAssignmentOne();



  public float getMarkForAssignmentTwo();



  public float getMarkForExam();



  public void setMarkForAssignmentOne(float newMark);



  public void setMarkForAssignmentTwo(float newMark);



  public void setMarkForExam(float newMark);
  
  
  
  public float calculateTotalMark();

}
