package datamanagement;

/**
 * Applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit, calculates grades for this unit and adds student
 * records for this unit to the collection of student unit records.
 */
public interface IUnit {

  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * Returns this unit's code.
   * @return String Code for this unit.
   */
  public String getUnitCode();



  /**
   * Returns this unit's name.
   * @return String Name of this unit.
   */
  public String getUnitName();



  /**
   * Returns the minimum mark required to qualify for an Alternative Assessment
   * in this unit.
   * @return float Value of mark required to qualify for an Alternative
   * Assessment in this unit.
   */
  public float getMinimumMarkForAdditionalExamination();



  /**
   * Returns the minimum mark required to obtain a Pass grade in this unit.
   * @return float Value of mark required to obtain a Pass grade in this unit.
   */
  public float getMinimumMarkForPass();



  /**
   * Returns the minimum mark required to obtain a Credit grade in this unit.
   * @return float Value of mark required to obtain a Credit grade in this
   * unit.
   */
  public float getMinimumMarkForCredit();



  /**
   * returns the minimum mark required to obtain a Distinction grade in this
   * unit.
   * @return float Value of mark required to obtain a Distinction grade in this
   * unit.
   */
  public float getMinimumMarkForDistinction();



  /**
   * returns the minimum mark required to obtain a High Distinction grade in
   * this unit.
   * @return float Value of mark required to obtain a High Distinction grade in
   * this unit.
   */
  public float getMinimumMarkForHighDistinction();



  /**
   * Returns the weighting for assessment one in this unit.
   * @return int Weighting used for assignment one in this unit.
   */
  public int getWeightOfAssignmentOne();



  /**
   * Returns the weighting for assessment two in this unit.
   * @return int Weighting used for assignment two in this unit.
   */
  public int getWeightOfAssignmentTwo();



  /**
   * Returns the weighting for the exam in this unit.
   * @return int Weighting used for the exam in this unit.
   */
  public int getWeightOfExam();



  /**
   * Returns a specified student's (single) record for this unit.
   * @param studentID String student identification number.
   * @return IStudentUnitRecord Student record for this unit.
   */
  public IStudentUnitRecord getStudentUnitRecord(int studentID);



  /**
   * Returns the entire collection of student records for this unit.
   * @return StudentUnitRecordList Collection of student records for this unit.
   */
  public StudentUnitRecordList getStudentUnitRecordList();



  /**
   * Sets the minimum mark required to qualify for an Alternative Assessment
   * in this unit.
   * @param cutoff float The minimum mark required to qualify for an
   *               Alternative Assessment in this unit.
   */
  public void setMinimumMarkForAdditionalExamination(float cutoff);



  /**
   * Sets the minimum mark required to obtain a Pass grade in this unit.
   * @param cutoff float The minimum mark required to obtain a Pass grade
   *               in this unit.
   */
  public void setMinimumMarkForPass(float cutoff);



  /**
   * Sets the minimum mark required to obtain a Credit grade in this unit.
   * @param cutoff float The minimum mark required to obtain a Credit
   *               grade in this unit.
   */
  public void setMinimumMarkForCredit(float cutoff);



  /**
   * Sets the minimum mark required to obtain a Distinction grade in this unit.
   * @param cutoff float The minimum mark required to obtain a Distinction
   *               grade in this unit.
   */
  public void setMinimumMarkForDistinction(float cutoff);



  /**
   *  Sets the minimum mark required to obtain a High Distinction grade in
   *  this unit.
   *  @param cutoff float The minimum mark required to obtain a High
   *                Distinction grade in this unit.
   */
  public void setMinimumMarkForHighDistinction(float cutoff);



  /**
   * Sets the weightings for the 3 assessments for this unit.
   * @param asg1Wgt int Sets integer weighting used for assignment one.
   * @param asg2Wgt int Sets integer weighting used for assignment one.
   * @param examWgt int Sets integer weighting used for exam.
   */
  public void setWeightsOfAssessments(int asg1Wgt, int asg2Wgt, int examWgt);



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Computes the correct grade for this unit (accounting for this unit's
   * assessment weightings and specified grade minimums).
   * @param asg1 float student mark for assignment one in this unit.
   * @param asg2 float student mark for assignment two in this unit.
   * @param exam float student mark for the exam in this unit.
   * @return String Final grade for this unit e.g. "HD".
   */
  public String calculateGrade(float asg1, float asg2, float exam);



  /**
   * Adds a student record to the collection of student records for this unit.
   * @param record IStudentUnitRecord Student record to be added to the
   *               collection of student records for this unit.
   */
  public void addStudentUnitRecord(IStudentUnitRecord record);



}
