package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord
{
  // ===========================================================================
  // Variables
  // ===========================================================================



  private Integer studentId_;
  private String unitCode_;

  private float assessmentOneMark_;
  private float assessmentTwoMark_;
  private float examMark_;


  
  // ===========================================================================
  // Constructors
  // ===========================================================================



  public StudentUnitRecord(Integer studentId, String unitCode, 
          float assessmentOneMark, float assessmentTwoMark, float examMark)
  {
    this.studentId_ = studentId;
    this.unitCode_ = unitCode;
    this.setAssessmentOneMark(assessmentOneMark);
    this.setAssessmentTwoMark(assessmentTwoMark);
    this.setExamMark(examMark);
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



  public float getTotal()
  {
    return assessmentOneMark_ + assessmentTwoMark_ + examMark_;

  }



  public void setAssessmentOneMark(float newMark) 
  {
    boolean isNegative = newMark < 0;
    boolean isGreaterThanWeight = newMark > UnitManager.getInstance().getUnit(unitCode_)
            .getWeightOfAssignmentOne();

    if (isNegative || isGreaterThanWeight) {
      throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
    }
    else {
      this.assessmentOneMark_ = newMark;
    }
  }



  public void setAssessmentTwoMark(float newMark)
  {
    boolean isNegative = newMark < 0;
    boolean isGreaterThanWeight = newMark > UnitManager.getInstance().getUnit(unitCode_)
            .getWeightOfAssignmentTwo();

    if (isNegative || isGreaterThanWeight) {
      throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
    }
    else {
      this.assessmentTwoMark_ = newMark;
    }
  }



  public void setExamMark(float newMark)
  {
    boolean isNegative = newMark < 0;
    boolean isGreaterThanWeight = newMark > UnitManager.getInstance().getUnit(unitCode_)
            .getWeightOfExam();

    if (isNegative || isGreaterThanWeight) {
      throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
    }
    else {
      this.examMark_ = newMark;
    }
  }

}
