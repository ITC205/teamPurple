package datamanagement;

/**
 * Acts as proxy for unit, implementing shared IUnit interface.
 * Applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit, calculates grades for this unit and adds student
 * records for this unit to the collection of student unit records.
 */
public class UnitProxy
  implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  private String unitCode_;
  private String unitName_;

  private UnitManager unitManager_;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates a new UnitProxy instance, using just unit code and name and
   * referencing the singleton unitManager_ that is used to identify the
   * matching Unit instance.
   */
  public UnitProxy(String unitCode, String unitName)
  {
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;
    this.unitManager_ = UnitManager.getInstance();
  }



  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitCode()
  {
    return this.unitCode_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitName()
  {
    return this.unitName_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForAdditionalExamination()
  {
    return this.unitManager_.getUnit(unitCode_)
                           .getMinimumMarkForAdditionalExamination();
  }



  /**
   *
   */
  @Override
  public float getMinimumMarkForPass()
  {
    return this.unitManager_.getUnit(unitCode_)
                           .getMinimumMarkForPass();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForCredit()
  {
    return this.unitManager_.getUnit(unitCode_)
                           .getMinimumMarkForCredit();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForDistinction()
  {
    return this.unitManager_.getUnit(unitCode_)
                           .getMinimumMarkForDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForHighDistinction()
  {
    return unitManager_.getUnit(unitCode_)
                      .getMinimumMarkForHighDistinction();
  }



  // TODO: this is a temporary hack for renamed method used elsewhere
  // TODO: delete this post merge, after method calls are renamed
  public int getAsg1Weight() {
    return getWeightOfAssignmentOne();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentOne()
  {
    return unitManager_.getUnit(unitCode_)
                      .getWeightOfAssignmentOne();
  }



  // TODO: this is a temporary hack for renamed method used elsewhere
  // TODO: delete this post merge, after method calls are renamed
  public int getAsg2Weight() {
    return getWeightOfAssignmentTwo();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentTwo()
  {
    return unitManager_.getUnit(unitCode_)
                      .getWeightOfAssignmentTwo();
  }



  // TODO: this is a temporary hack for renamed method used elsewhere
  // TODO: delete this post merge, after method calls are renamed
  public int getExamWeight() {
    return getWeightOfExam();
  }
    /**
     * {@inheritDoc}
     */
  @Override
  public int getWeightOfExam()
  {
    return unitManager_.getUnit(unitCode_)
                      .getWeightOfExam();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    return unitManager_.getUnit(unitCode_)
                      .getStudentUnitRecord(studentId);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getStudentUnitRecordList()
  {
    return unitManager_.getUnit(unitCode_)
                      .getStudentUnitRecordList();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForAdditionalExamination(float minimumMark)
  {
    unitManager_.getUnit(unitCode_)
               .setMinimumMarkForAdditionalExamination(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForPass(float minimumMark)
  {
    unitManager_.getUnit(unitCode_)
               .setMinimumMarkForPass(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float minimumMark)
  {
    unitManager_.getUnit(unitCode_)
               .setMinimumMarkForCredit(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForDistinction(float minimumMark)
  {
    unitManager_.getUnit(unitCode_)
               .setMinimumMarkForDistinction(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForHighDistinction(float minimumMark)
  {
    unitManager_.getUnit(unitCode_)
               .setMinimumMarkForHighDistinction(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int weightOfAssignmentOne,
                                      int weightOfAssignmentTwo,
                                      int weightOfExam)
  {
    unitManager_.getUnit(unitCode_)
               .setWeightsOfAssessments(weightOfAssignmentOne,
                                        weightOfAssignmentTwo,
                                        weightOfExam);
  }



  //===========================================================================
  // Methods
  //===========================================================================

  // TODO: this is a temporary hack for renamed method used elsewhere
  // TODO: delete this post merge, after method calls are renamed
  public String getGrade(float m, float n, float p)
  {
    return calculateGrade( m, n, p);
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public String calculateGrade(float markForAssignmentOne,
                               float markForAssignmentTwo,
                               float markForExam)
  {
    return unitManager_.getUnit(unitCode_)
                      .calculateGrade(markForAssignmentOne,
                                      markForAssignmentTwo,
                                      markForExam);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
  {
    unitManager_.getUnit(unitCode_)
               .addStudentUnitRecord(studentUnitRecord);
  }



}
