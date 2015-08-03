package datamanagement;

/**
 * Proxy class for Unit
 */
public class UnitProxy
  implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  private String unitCode_;
  private String unitName_;

  UnitManager unitManager_;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates a new UnitProxy with a singleton unitManager
   */
  public UnitProxy(String unitCode, String unitName)
  {
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;
    this.unitManager_ = UnitManager.getInstance();
  }

  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * calculates the correct grade for this unit
   * @param assignmentOneMark student's mark (float) for assignment one
   * @param assignmentTwoMark student's mark (float) for assignment two
   * @param examMark student's mark (float) for the exam
   */
  public String calculateGrade(float assignmentOneMark,
                               float assignmentTwoMark, float examMark)
  {
    // TODO: refactor ref to: this.unitManager_.getUnit(this.unitCode_)
    return this.unitManager_.getUnit(this.unitCode_)
                            .calculateGrade(assignmentOneMark,
                                            assignmentTwoMark, examMark);
  }



  /**
   * adds a student's record to the unit records
   * @param record studentUnitRecord
   */
  public void addStudentRecord(IStudentUnitRecord record)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .addStudentRecord(record);
  }




  /**
   * returns this unit's code
   * @return unitCode (String)
   */
  public String getUnitCode()
  {
    return this.unitCode_;
  }


  /**
   * returns this unit's name
   * @return unitName (String)
   */
  public String getUnitName()
  {
    return this.unitName_;
  }


  /**
   * returns the minimum mark required to qualify for an additional examination
   * @return mark (float)
   */
  public float getAdditionalExaminationMinimumMark()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getAdditionalExaminationMinimumMark();
  }



  /**
   * returns the minimum mark required to attain a Pass grade
   * @return mark (float)
   */
  public float getPassMinimumMark()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getPassMinimumMark();
  }



  /**
   * returns the minimum mark required to attain a Credit grade
   * @return mark (float)
   */
  public float getCreditMinimumMark()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getCreditMinimumMark();
  }



  /**
   * returns the minimum mark required to attain a Distinction grade
   * @return mark (float)
   */
  public float getDistinctionMinimumMark()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getDistinctionMinimumMark();
  }



  /**
   * returns the minimum mark required to attain a High Distinction grade
   * for this unit
   * @return mark (float)
   */
  public float getHighDistinctionMinimumMark()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getHighDistinctionMinimumMark();
  }



  /**
   * returns the weighting for assignment one in this unit
   * @return weight (int)
   */
  public int getAssignmentOneWeight()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getAssignmentOneWeight();
  }



  /**
   * returns the weighting for assignment two in this unit
   * @return weight (int)
   */
  public int getAssignmentTwoWeight()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getAssignmentTwoWeight();
  }



  /**
   * returns the weighting for the exam in this unit
   * @return weight (int)
   */
  public int getExamWeight()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getExamWeight();
  }


  /**
   * returns a student's record for this unit
   * @param studentId identifies student
   * @return studentUnitRecord
   */
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getStudentUnitRecord(studentId);
  }



  /**
   * returns all students' records for this unit
   * @return studentUnitRecordList
   */
  public StudentUnitRecordList getStudentUnitRecords()
  {
    return this.unitManager_.getUnit(this.unitCode_)
                            .getStudentUnitRecords();
  }



  public void setAdditionalExaminationMinimumMark(float mark)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .setAdditionalExaminationMinimumMark(mark);
  }



  public void setPassMinimumMark(float mark)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .setPassMinimumMark(mark);
  }



  public void setCreditMinimumMark(float mark)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .setCreditMinimumMark(mark);
  }



  public void setDistinctionMinimumMark(float mark)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .setDistinctionMinimumMark(mark);
  }



  public void setHighDistinctionMinimumMark(float mark)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .setHighDistinctionMinimumMark(mark);
  }



  /**
   * sets this unit's weightings
   * @param assignmentOneWeight weight of assignment one in overall mark
   * @param assignmentTwoWeight weight of assignment two in overall mark
   * @param examWeight weight of the exam in overall mark
   */
  public void setAssessmentWeights(int assignmentOneWeight,
                                   int assignmentTwoWeight, int examWeight)
  {
    this.unitManager_.getUnit(this.unitCode_)
                     .setAssessmentWeights(assignmentOneWeight,
                                           assignmentTwoWeight, examWeight);
  }



}
