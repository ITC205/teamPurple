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
  //============================================================================
  // Variables
  //============================================================================



  private String unitCode_;
  private String unitName_;
  private UnitManager unitManager_;



  //============================================================================
  // Constructors
  //============================================================================



  /**
   * Creates a new UnitProxy instance, using just unit code and name and
   * referencing the singleton unitManager_ that is used to identify the
   * matching Unit instance.
   */
  public UnitProxy(String unitCode, String unitName)
  {
    setUnitCode(unitCode);
    setUnitName(unitName);
    setUnitManager(UnitManager.getInstance());
  }



  //============================================================================
  // Getters & setters
  //============================================================================



  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitCode()
  {
    return unitCode_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitName()
  {
    return unitName_;
  }



  /**
   * Returns the UnitManger instance that manages the collection of all units.
   * @return UnitManager The UnitManger instance that manages the collection
   *                     of all units.
   */
  private UnitManager getUnitManager()
  {
    return unitManager_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForAdditionalExamination()
  {
    return resolveUnit().getMinimumMarkForAdditionalExamination();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForPass()
  {
    return resolveUnit().getMinimumMarkForPass();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForCredit()
  {
    return resolveUnit().getMinimumMarkForCredit();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForDistinction()
  {
    return resolveUnit().getMinimumMarkForDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForHighDistinction()
  {
    return resolveUnit().getMinimumMarkForHighDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentOne()
  {
    return resolveUnit().getWeightOfAssignmentOne();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentTwo()
  {
    return resolveUnit().getWeightOfAssignmentTwo();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfExam()
  {
    return resolveUnit().getWeightOfExam();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    return resolveUnit().getStudentUnitRecord(studentId);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getAllStudentUnitRecords()
  {
    return resolveUnit().getAllStudentUnitRecords();
  }



  /**
   * Sets Unit code.
   * @param unitCode String This unit code.
   */
  private void setUnitCode(String unitCode)
  {
    this.unitCode_ = unitCode;
  }



  /**
   * Sets Unit name.
   * @param unitName String This unit name.
   */
  private void setUnitName(String unitName)
  {
    unitName_ = unitName;
  }



  private void setUnitManager(UnitManager unitManager)
  {
    unitManager_= unitManager;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForAdditionalExamination(float minimumMark)
  {
    resolveUnit().setMinimumMarkForAdditionalExamination(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForPass(float minimumMark)
  {
    resolveUnit().setMinimumMarkForPass(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float minimumMark)
  {
    resolveUnit().setMinimumMarkForCredit(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForDistinction(float minimumMark)
  {
    resolveUnit().setMinimumMarkForDistinction(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForHighDistinction(float minimumMark)
  {
    resolveUnit().setMinimumMarkForHighDistinction(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int weightOfAssignmentOne,
                                      int weightOfAssignmentTwo,
                                      int weightOfExam)
  {
    resolveUnit().setWeightsOfAssessments(weightOfAssignmentOne,
                                          weightOfAssignmentTwo,
                                          weightOfExam);
  }



  //============================================================================
  // Methods
  //============================================================================



  /**
   * {@inheritDoc}
   */
  @Override
  public String calculateGrade(float markForAssignmentOne,
                               float markForAssignmentTwo,
                               float markForExam)
  {
    return resolveUnit().calculateGrade(markForAssignmentOne,
                                        markForAssignmentTwo,
                                        markForExam);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
  {
    resolveUnit().addStudentUnitRecord(studentUnitRecord);
  }



  /**
   * Returns the actual unit that this object proxies.
   * @return IUnit Actual unit that this object proxies.
   */
  private IUnit resolveUnit() {
    return getUnitManager().findUnit(getUnitCode());
  }

}
