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
   * Returns actual unit that this object proxies.
   * @return IUnit Actual unit that this object proxies.
   */
  private IUnit getActualUnit() {
    return this.getUnitManager().getUnit(this.getUnitCode());
  }



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
   * Returns the UnitManger instance that manages the collection of all units.
   * @return UnitManager The UnitManger instance that manages the collection
   *                     of all units.
   */
  private UnitManager getUnitManager()
  {
    return this.unitManager_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForAdditionalExamination()
  {
    return getActualUnit().getMinimumMarkForAdditionalExamination();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForPass()
  {
    return getActualUnit().getMinimumMarkForPass();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForCredit()
  {
    return getActualUnit().getMinimumMarkForCredit();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForDistinction()
  {
    return getActualUnit().getMinimumMarkForDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForHighDistinction()
  {
    return getActualUnit().getMinimumMarkForHighDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentOne()
  {
    return getActualUnit().getWeightOfAssignmentOne();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentTwo()
  {
    return getActualUnit().getWeightOfAssignmentTwo();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfExam()
  {
    return getActualUnit().getWeightOfExam();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    return getActualUnit().getStudentUnitRecord( studentId );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getAllStudentUnitRecords()
  {
    return getActualUnit().getAllStudentUnitRecords();
  }




  /**
   *
   */
  private void setUnitCode(String unitCode)
  {
    this.unitCode_ = unitCode;
  }



  /**
   *
   */
  private void setUnitName(String unitName)
  {
    this.unitName_ = unitName;
  }



  private void setUnitManager(UnitManager unitManager)
  {
    this.unitManager_= unitManager;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForAdditionalExamination(float minimumMark)
  {
    getActualUnit().setMinimumMarkForAdditionalExamination(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForPass(float minimumMark)
  {
    getActualUnit().setMinimumMarkForPass(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float minimumMark)
  {
    getActualUnit().setMinimumMarkForCredit(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForDistinction(float minimumMark)
  {
    getActualUnit().setMinimumMarkForDistinction(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForHighDistinction(float minimumMark)
  {
    getActualUnit().setMinimumMarkForHighDistinction(minimumMark);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int weightOfAssignmentOne,
                                      int weightOfAssignmentTwo,
                                      int weightOfExam)
  {
    getActualUnit().setWeightsOfAssessments(weightOfAssignmentOne,
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
    return getActualUnit().calculateGrade(markForAssignmentOne,
                                          markForAssignmentTwo,
                                          markForExam);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
  {
    getActualUnit().addStudentUnitRecord(studentUnitRecord);
  }
  
}
