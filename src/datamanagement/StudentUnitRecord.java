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
	
	
	
	public StudentUnitRecord(Integer studentId, String unitCode, 
			float assessmentOneMark, float assessmentTwoMark, float examMark)
	{
		this.studentId_ = studentId;
		this.unitCode_ = unitCode;
		this.setAssessmentOneMark(assessmentOneMark);
		this.setAssessmentTwoMark(assessmentTwoMark);
		this.setExamMark(examMark);
	}

	
	
	//===========================================================================
  // Accessors
  //===========================================================================
	
	
	
	public Integer getStudentId()
	{
		return studentId_;
	}

	
	
	public String getUnitCode()
	{
		return unitCode_;
	}

	
	
	public float getAssessmentOneMark()
	{
		return assessmentOneMark_;
	}
	
	
	
	public float getAssessmentTwoMark()
	{
		return assessmentTwoMark_;
	}

	
	
	public float getExamMark()
	{
		return examMark_;
	}

	
	
	public float getTotal() // Get total mark? get grade/final grade?
	{
		return assessmentOneMark_ + assessmentTwoMark_ + examMark_;

	}
	
	
	
	public void setAssessmentOneMark(float newMark) // newMark vs assessmentOneMark?
	{
		boolean isNegative = newMark < 0;
		boolean isGreaterThanWeight = newMark > UnitManager.UM()
				.getUnit(unitCode_).getAsg1Weight();
		
		if (isNegative || isGreaterThanWeight) {
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessmentOneMark_ = newMark;
	}

	
	// See 5.7 - #53 Complex Conditionals
	public void setAssessmentTwoMark(float newMark) 
	{
		boolean isNegative = newMark < 0;
		boolean isGreaterThanWeight = newMark > UnitManager.UM()
				.getUnit(unitCode_).getAsg2Weight();
		
		if (isNegative || isGreaterThanWeight) { 
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessmentTwoMark_ = newMark;
	}

	
	
	public void setExamMark(float newMark) // As above, or different?
	{
		boolean isNegative = newMark < 0;
		boolean isGreaterThanWeight = newMark > UnitManager.UM()
				.getUnit(unitCode_).getExamWeight();
		
		if (isNegative || isGreaterThanWeight) {
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.examMark_ = newMark;
	}

}
