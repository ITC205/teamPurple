package datamanagement;

/**
 * Acts as proxy for unit, implementing shared IUnit interface.
 * Applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit, calculates grades for this unit and adds student
 * records for this unit to the collection of student unit records.
 */
public class UnitProxy implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  private String UC;
  private String un;

  UnitManager um;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates a new UnitProxy instance, using just unit code and name and
   * referencing the singleton unitManager that is used to identify the
   * matching Unit instance.
   */
  public UnitProxy(String unitCode, String unitName)
  {
    this.UC = unitCode;
    this.un = unitName;
    this.um = UnitManager.UM();
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
    return this.UC;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitName()
  {
    return this.un;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForAdditionalExamination()
  {
    return this.um.getUnit(UC).getMinimumMarkForAdditionalExamination();
  }



  /**
   *
   */
  @Override
  public float getMinimumMarkForPass()
  {
    return this.um.getUnit(UC).getMinimumMarkForPass();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForCredit()
  {
    return this.um.getUnit(UC).getMinimumMarkForCredit();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForDistinction()
  {
    return this.um.getUnit(UC).getMinimumMarkForDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForHighDistinction()
  {
    return um.getUnit(UC).getMinimumMarkForHighDistinction();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentOne()
  {
    return um.getUnit(UC).getWeightOfAssignmentOne();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentTwo()
  {
    return um.getUnit(UC).getWeightOfAssignmentTwo();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfExam()
  {
    return um.getUnit(UC).getWeightOfExam();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public IStudentUnitRecord getStudentUnitRecord(int s)
  {
    return um.getUnit(UC).getStudentUnitRecord(s);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getStudentUnitRecordList()
  {
    return um.getUnit(UC).getStudentUnitRecordList();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForAdditionalExamination(float cutoff)
  {
    um.getUnit(UC).setMinimumMarkForAdditionalExamination(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForPass(float cutoff)
  {
    um.getUnit(UC).setMinimumMarkForPass(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float cutoff)
  {
    um.getUnit(UC).setMinimumMarkForCredit(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForDistinction(float cutoff)
  {
    um.getUnit(UC).setMinimumMarkForDistinction(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForHighDistinction(float cutoff)
  {
    um.getUnit(UC).setMinimumMarkForHighDistinction(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int asg1Wgt, int asg2Wgt, int examWgt)
  {
    um.getUnit(UC).setWeightsOfAssessments(asg1Wgt, asg2Wgt, examWgt);
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String calculateGrade(float f1, float f2, float f3)
  {
    return um.getUnit(UC).calculateGrade(f1, f2, f3);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord record)
  {
    um.getUnit(UC).addStudentUnitRecord(record);
  }



}
