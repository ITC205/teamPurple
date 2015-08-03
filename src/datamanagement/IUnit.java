package datamanagement;

/**
 *
 */
public interface IUnit {

  //===========================================================================
  // Getters & setters
  //===========================================================================

  public String getUnitCode();
  public String getUnitName();

  public float getAeCutoff();
  public float getPsCutoff();
  public float getCrCutoff();
  public float getDiCuttoff();
  public float getHdCutoff();

  public int getAsg1Weight();
  public int getAsg2Weight();
  public int getExamWeight();

  public IStudentUnitRecord getStudentRecord(int studentID );
  public StudentUnitRecordList listStudentRecords();

  public void  setAeCutoff(float cutoff);
  public void  setPsCutoff1(float cutoff);
  public void  setCrCutoff(float cutoff);
  public void  setDiCutoff(float cutoff);
  public void  setHdCutoff(float cutoff);

  public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);

  //===========================================================================
  // Methods
  //===========================================================================

  public String getGrade(float asg1, float asg2, float exam);

  public void addStudentRecord(IStudentUnitRecord record );


}
