package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord
{
	
	//===========================================================================
  // Variables
  //===========================================================================
	
	
	
	private Integer studentId_;
	private String unitCode_;
	private StudentUnitRecordManager manager_;

	
	
	//===========================================================================
  // Constructors
  //===========================================================================
	
	
	
	public StudentUnitRecordProxy(Integer id, String code)
	{
		this.studentId_ = id;
		this.unitCode_ = code;
		this.manager_ = StudentUnitRecordManager.getInstance();
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
		
		return manager_.getStudentUnitRecord(studentId_, unitCode_).
				getAssessmentOneMark(); // Okay?
	}
	
	
	
	public float getAssessmentTwoMark()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).
				getAssessmentTwoMark();
	}
	
	
	
	public float getExamMark()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).getExamMark();
	}

	
	
	public float getTotal()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).getTotal();
	}
	
	
	
	public void setAssessmentOneMark(float newMark)
	{
		manager_.getStudentUnitRecord(studentId_, unitCode_).
				setAssessmentOneMark(newMark);
	}

	

	public void setAssessmentTwoMark(float newMark)
	{
		manager_.getStudentUnitRecord(studentId_, unitCode_).
				setAssessmentTwoMark(newMark); // Okay? Double tab
	}

	

	public void setExamMark(float newMark)
	{
		manager_.getStudentUnitRecord(studentId_, unitCode_).setExamMark(newMark);
	}
	
}
