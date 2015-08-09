package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord
{
  // ===========================================================================
  // Variables
  // ===========================================================================



  private Integer studentId_;
  private String unitCode_;
  private StudentUnitRecordManager manager_;



  // ===========================================================================
  // Constructors
  // ===========================================================================



  public StudentUnitRecordProxy(Integer id, String code)
  {
    this.studentId_ = id;
    this.unitCode_ = code;
    this.manager_ = StudentUnitRecordManager.getInstance();
  }



  // ===========================================================================
  // Getters & setters
  // ===========================================================================



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

    return manager_.getStudentUnitRecord(studentId_, unitCode_)
            .getAssessmentOneMark();
  }



  public float getAssessmentTwoMark()
  {
    return manager_.getStudentUnitRecord(studentId_, unitCode_)
            .getAssessmentTwoMark();
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
    manager_.getStudentUnitRecord(studentId_, unitCode_)
            .setAssessmentOneMark(newMark);
  }



  public void setAssessmentTwoMark(float newMark)
  {
    manager_.getStudentUnitRecord(studentId_, unitCode_)
            .setAssessmentTwoMark(newMark);
  }



  public void setExamMark(float newMark)
  {
    manager_.getStudentUnitRecord(studentId_, unitCode_).setExamMark(newMark);
  }

}
