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
	
	
	
	public Integer getStudentID()
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
		if (newMark < 0 || 
				newMark > UnitManager.UM().getUnit(unitCode_).getAsg1Weight()) { // Split over two lines? Create validation method?
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessmentOneMark_ = newMark;
	}

	
	
	public void setAssessmentTwoMark(float newMark)
	{
		if (newMark < 0 || 
				newMark > UnitManager.UM().getUnit(unitCode_).getAsg2Weight()) { // Split over two lines? Create validation method?
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.assessmentTwoMark_ = newMark;
	}

	
	
	public void setExamMark(float newMark) // As above, or different?
	{
		if (newMark < 0 || 
				newMark > UnitManager.UM().getUnit(unitCode_).getExamWeight()) { // Split over two lines? Create validation method?
			throw new RuntimeException(
					"Mark cannot be less than zero or greater than assessment weight");
		}
		this.examMark_ = newMark;
	}

}
