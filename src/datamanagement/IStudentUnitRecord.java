package datamanagement;

public interface IStudentUnitRecord
{
	public Integer getStudentID();

	public String getUnitCode();

	public void setAssessmentOneMark(float newMark);

	public float getAssessmentOneMark();

	public void setAssessmentTwoMark(float newMark);

	public float getAssessmentTwoMark();

	public void setExamMark(float newMark);

	public float getExamMark();

	public float getTotal(); // Change name?
}
