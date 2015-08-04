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
  public float getAeCutoff()
  {
    return this.um.getUnit(UC).getAeCutoff();
  }



  /**
   *
   */
  @Override
  public float getPsCutoff()
  {
    return this.um.getUnit(UC).getPsCutoff();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getCrCutoff()
  {
    return this.um.getUnit(UC).getCrCutoff();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getDiCuttoff()
  {
    return this.um.getUnit(UC).getDiCuttoff();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getHdCutoff()
  {
    return um.getUnit(UC).getHdCutoff();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getAsg1Weight()
  {
    return um.getUnit(UC).getAsg1Weight();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getAsg2Weight()
  {
    return um.getUnit(UC).getAsg2Weight();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getExamWeight()
  {
    return um.getUnit(UC).getExamWeight();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public IStudentUnitRecord getStudentRecord(int s)
  {
    return um.getUnit(UC).getStudentRecord(s);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList listStudentRecords()
  {
    return um.getUnit(UC).listStudentRecords();
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setAeCutoff(float cutoff)
  {
    um.getUnit(UC).setAeCutoff(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setPsCutoff1(float cutoff)
  {
    um.getUnit(UC).setPsCutoff1(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setCrCutoff(float cutoff)
  {
    um.getUnit(UC).setCrCutoff(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setDiCutoff(float cutoff)
  {
    um.getUnit(UC).setDiCutoff(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setHdCutoff(float cutoff)
  {
    um.getUnit(UC).setHdCutoff(cutoff);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt)
  {
    um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String getGrade(float f1, float f2, float f3)
  {
    return um.getUnit(UC).getGrade(f1, f2, f3);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentRecord(IStudentUnitRecord record)
  {
    um.getUnit(UC).addStudentRecord(record);
  }



}
