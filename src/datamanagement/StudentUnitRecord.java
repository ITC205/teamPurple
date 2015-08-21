package datamanagement;

public class StudentUnitRecord 
  implements IStudentUnitRecord
{
  // ===========================================================================
  // Variables
  // ===========================================================================



  private Integer studentId_;
  private String unitCode_;

  private float markForAssignmentOne_;
  private float markForAssignmentTwo_;
  private float markForExam_;


  
  // ===========================================================================
  // Constructors
  // ===========================================================================



  public StudentUnitRecord(Integer studentId, String unitCode,
                            float markForAssignmentOne, 
                            float markForAssignmentTwo,
                            float markForExam)
  {
    studentId_ = studentId;
    unitCode_ = unitCode;
    setMarkForAssignmentOne(markForAssignmentOne);
    setMarkForAssignmentTwo(markForAssignmentTwo);
    setMarkForExam(markForExam);
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



  public float getMarkForAssignmentOne()
  {
    return markForAssignmentOne_;
  }



  public float getMarkForAssignmentTwo()
  {
    return markForAssignmentTwo_;
  }



  public float getMarkForExam()
  {
    return markForExam_;
  }



  public float calculateTotalMark()
  {
    return markForAssignmentOne_ + markForAssignmentTwo_ + markForExam_;
  }



  public void setMarkForAssignmentOne(float newMark) 
  {
    boolean isNegative = newMark < 0;
    boolean isGreaterThanWeight = newMark > UnitManager.getInstance()
                                            .findUnit(unitCode_)
                                            .getWeightOfAssignmentOne();

    if (isNegative || isGreaterThanWeight) {
      throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
    }
    else {
      this.markForAssignmentOne_ = newMark;
    }
  }



  public void setMarkForAssignmentTwo(float newMark)
  {
    boolean isNegative = newMark < 0;
    boolean isGreaterThanWeight = newMark > UnitManager.getInstance()
                                            .findUnit(unitCode_)
                                            .getWeightOfAssignmentTwo();

    if (isNegative || isGreaterThanWeight) {
      throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
    }
    else {
      this.markForAssignmentTwo_ = newMark;
    }
  }



  public void setMarkForExam(float newMark)
  {
    boolean isNegative = newMark < 0;
    boolean isGreaterThanWeight = newMark > UnitManager.getInstance()
                                            .findUnit(unitCode_)
                                            .getWeightOfExam();

    if (isNegative || isGreaterThanWeight) {
      throw new RuntimeException(
              "Mark cannot be less than zero or greater than assessment weight");
    }
    else {
      this.markForExam_ = newMark;
    }
  }

}
