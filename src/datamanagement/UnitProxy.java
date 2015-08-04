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
  public IStudentUnitRecord getStudentUnitRecord(int studentId )
  {
    return um.getUnit(UC).getStudentUnitRecord( studentId );
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
  public void setMinimumMarkForAdditionalExamination(float minimumMark )
  {
    um.getUnit(UC).setMinimumMarkForAdditionalExamination( minimumMark );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForPass(float minimumMark )
  {
    um.getUnit(UC).setMinimumMarkForPass( minimumMark );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float minimumMark )
  {
    um.getUnit(UC).setMinimumMarkForCredit( minimumMark );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForDistinction(float minimumMark )
  {
    um.getUnit(UC).setMinimumMarkForDistinction( minimumMark );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForHighDistinction(float minimumMark )
  {
    um.getUnit(UC).setMinimumMarkForHighDistinction( minimumMark );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int weightOfAssignmentOne, int weightOfAssignmentTwo, int weightOfExam )
  {
    um.getUnit(UC).setWeightsOfAssessments( weightOfAssignmentOne, weightOfAssignmentTwo, weightOfExam );
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String calculateGrade(float markForAssignmentOne, float markForAssignmentTwo, float markForExam )
  {
    return um.getUnit(UC).calculateGrade( markForAssignmentOne, markForAssignmentTwo, markForExam );
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord )
  {
    um.getUnit(UC).addStudentUnitRecord( studentUnitRecord );
  }



}
