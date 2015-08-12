package datamanagement;

public interface IStudentUnitRecord
{
  public Integer getStudentId();



  public String getUnitCode();



  public float getAssessmentOneMark();



  public float getAssessmentTwoMark();



  public float getExamMark();



  public float getTotalMark();



  public void setAssessmentOneMark(float newMark);



  public void setAssessmentTwoMark(float newMark);



  public void setExamMark(float newMark);


}
