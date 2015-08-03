package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord
{
	
	//===========================================================================
  // Variables
  //===========================================================================

	private Integer studentId_;
	private String unitCode_;
	private float assessmentOneMark_, assessmentTwoMark_, examMark_; // Separate out onto multiple lines?
																																	 // Use 'mark' or 'grade' or some other name?

	
	
	//===========================================================================
  // Constructors
  //===========================================================================
	
	public StudentUnitRecord(Integer studentId, String unitCode, float assessmentOneMark, float assessmentTwoMark,
														float examMark)
	{
		this.studentId_ = studentId;
		this.unitCode_ = unitCode;
		this.setAsg1(assessmentOneMark);
		this.setAsg2(assessmentTwoMark);
		this.setExam(examMark);
	}

	//===========================================================================
  // Accessors
  //===========================================================================
	
	public Integer getStudentID()
	{
		return studentId_;
	}

	public String getUnitCode()
	{
		return unitCode_;
	}

	public float getAsg1()
	{

		return assessmentOneMark_;
	}
	
	public float getAsg2()
	{
		return assessmentTwoMark_;
	}

	public float getExam()
	{
		return examMark_;
	}

	public float getTotal()
	{
		return assessmentOneMark_ + assessmentTwoMark_ + examMark_;

	}
	
	public void setAsg1(float a1)
	{
		if (a1 < 0 || a1 > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) {
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessmentOneMark_ = a1;
	}

	public void setAsg2(float a2)
	{
		if (a2 < 0 || a2 > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) {
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessmentTwoMark_ = a2;

	}

	public void setExam(float ex)
	{
		if (ex < 0 || ex > UnitManager.UM().getUnit(unitCode_).getExamWeight()) {
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.examMark_ = ex;
	}

}
