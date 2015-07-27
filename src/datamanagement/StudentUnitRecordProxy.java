package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord
{
	private Integer studentId_;
	private String unitCode_;
	private StudentUnitRecordManager manager_;

	public StudentUnitRecordProxy(Integer id, String code)
	{
		this.studentId_ = id;
		this.unitCode_ = code;
		this.manager_ = StudentUnitRecordManager.instance();
	}

	public Integer getStudentID()
	{
		return studentId_;
	}

	public String getUnitCode()
	{
		return unitCode_;
	}

	public void setAsg1(float mark)
	{
		manager_.getStudentUnitRecord(studentId_, unitCode_).setAsg1(mark);
	}

	public float getAsg1()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).getAsg1();
	}

	public void setAsg2(float mark)
	{
		manager_.getStudentUnitRecord(studentId_, unitCode_).setAsg2(mark);
	}

	public float getAsg2()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).getAsg2();
	}

	public void setExam(float mark)
	{
		manager_.getStudentUnitRecord(studentId_, unitCode_).setExam(mark);
	}

	public float getExam()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).getExam();
	}

	public float getTotal()
	{
		return manager_.getStudentUnitRecord(studentId_, unitCode_).getTotal();
	}
}
