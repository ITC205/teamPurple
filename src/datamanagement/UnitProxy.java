package datamanagement;

/**
 *
 */
public class UnitProxy implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  private String UC;
  private String un;

  UnitManager   um;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   *
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
   *
   */
  @Override
  public String getUnitCode()
  {
    return this.UC;
  }



  /**
   *
   */
  @Override
  public String getUnitName()
  {
    return this.un;
  }



  /**
   *
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
   *
   */
  @Override
  public float getCrCutoff() {
  return this.um.getUnit(UC).getCrCutoff();
  }



  /**
   *
   */
  @Override
  public float getDiCuttoff()
  {
    return this.um.getUnit(UC).getDiCuttoff();
  }



  /**
   *
   */
  @Override
  public float getHdCutoff()
  {
    return um.getUnit(UC).getHdCutoff();
  }



  /**
   *
   */
  @Override
  public int getAsg1Weight()
  {
    return um.getUnit(UC).getAsg1Weight();
  }



  /**
   *
   */
  @Override
  public int getAsg2Weight()
  {
    return um.getUnit(UC).getAsg2Weight();
  }



  /**
   *
   */
  @Override
  public int getExamWeight()
  {
    return um.getUnit(UC).getExamWeight();
  }



  /**
   *
   */
  @Override
  public IStudentUnitRecord getStudentRecord(int s)
  {
    return um.getUnit(UC).getStudentRecord(s);
  }



  /**
   *
   */
  @Override
  public StudentUnitRecordList listStudentRecords()
  {
    return um.getUnit(UC).listStudentRecords();
  }



  /**
   *
   */
  @Override
  public void setAeCutoff(float cutoff)
  {
    um.getUnit(UC).setAeCutoff( cutoff );
  }



  /**
   *
   */
  @Override
  public void setPsCutoff1(float cutoff)
  {
    um.getUnit(UC).setPsCutoff1( cutoff );
  }



  /**
   *
   */
  @Override
  public void setCrCutoff(float cutoff)
  {
    um.getUnit(UC).setCrCutoff( cutoff );
  }



  /**
   *
   */
  @Override
  public void setDiCutoff(float cutoff)
  {
    um.getUnit(UC).setDiCutoff(cutoff);
  }



  /**
   *
   */
  @Override
  public void setHdCutoff(float cutoff)
  {
    um.getUnit(UC).setHdCutoff( cutoff );
  }



  /**
   *
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
   *
   */
  @Override
  public String getGrade(float f1, float f2, float f3)
  {
    return um.getUnit(UC).getGrade(f1, f2, f3);
  }



  /**
   *
   */
  @Override
  public void addStudentRecord(IStudentUnitRecord record)
  {
    um.getUnit(UC).addStudentRecord(record);
  }



}
