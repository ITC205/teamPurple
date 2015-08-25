package datamanagement;

/**
 * Applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit, calculates grades for this unit and adds student
 * records for this unit to the collection of student unit records.
 */
public interface IUnit
{

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
   * Returns the minimum mark required to qualify for an Additional Examination
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
   * Returns the entire collection of student records for this unit.
   * @return StudentUnitRecordList Collection of student records for this unit.
   */
  public StudentUnitRecordList getAllStudentUnitRecords();



  /**
   * Sets the minimum mark required to qualify for an Additional Examination
   * in this unit.
   * @param minimumMark float The minimum mark required to qualify for an
   *        Alternative Assessment in this unit.
   */
  public void setMinimumMarkForAdditionalExamination(float minimumMark);



  /**
   * Sets the minimum mark required to obtain a Pass grade in this unit.
   * @param minimumMark float The minimum mark required to obtain a Pass grade
   *        in this unit.
   */
  public void setMinimumMarkForPass(float minimumMark);



  /**
   * Sets the minimum mark required to obtain a Credit grade in this unit.
   * @param minimumMark float The minimum mark required to obtain a Credit
   *        grade in this unit.
   */
  public void setMinimumMarkForCredit(float minimumMark);



  /**
   * Sets the minimum mark required to obtain a Distinction grade in this unit.
   * @param minimumMark float The minimum mark required to obtain a Distinction
   *        grade in this unit.
   */
  public void setMinimumMarkForDistinction(float minimumMark);



  /**
   *  Sets the minimum mark required to obtain a High Distinction grade in
   *  this unit.
   *  @param minimumMark float The minimum mark required to obtain a High
   *         Distinction grade in this unit.
   */
  public void setMinimumMarkForHighDistinction(float minimumMark);



  /**
   * Sets the weightings for the 3 assessments for this unit.
   * @param weightOfAssignmentOne int Weight to apply to assignment one result.
   * @param weightOfAssignmentTwo int Weight to apply to assignment one result.
   * @param weightOfExam int Weight to apply to exam mark result.
   */
  public void setWeightsOfAssessments(int weightOfAssignmentOne,
                                      int weightOfAssignmentTwo,
                                      int weightOfExam);



  /**
   * Returns a specified student's (single) record for this unit.
   * @param studentId String student identification number.
   * @return IStudentUnitRecord Student record for this unit.
   */
  public IStudentUnitRecord findUnitRecordByStudent(int studentId);



  /**
   * Computes the correct grade for this unit (accounting for this unit's
   * assessment weightings and specified grade minimums).
   * @param markForAssignmentOne float Mark for assignment one in this unit.
   * @param markForAssignmentTwo float Mark for assignment two in this unit.
   * @param markForExam float Mark for the exam in this unit.
   * @return String Final grade for this unit e.g. "HD".
   */
  public String calculateGrade(float markForAssignmentOne,
                               float markForAssignmentTwo,
                               float markForExam);



  /**
   * Adds a student record to the collection of student records for this unit.
   * @param studentUnitRecord IStudentUnitRecord Student record to be added to
   *        the collection of student records for this unit.
   */
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord);

}
