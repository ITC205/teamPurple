package datamanagement;

public interface IStudentUnitRecord
{
	public Integer getStudentID();

	public String getUnitCode();

	public float getAssessmentOneMark();
	
	public float getAssessmentTwoMark();
	
	public float getExamMark();

	public float getTotal(); // Change name?

	public void setAssessmentOneMark(float newMark);
	
	public void setAssessmentTwoMark(float newMark);

	public void setExamMark(float newMark);


}
