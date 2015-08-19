package datamanagement;

/**
 * Default implementation of IUnit interface.
 * Applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit, calculates grades for this unit and adds student
 * records for this unit to the collection of student unit records.
 */
public class Unit
  implements IUnit
{
  //============================================================================
  // Variables
  //============================================================================



  private static final float MINIMUM_VALID_MARK = 0;
  private static final float MAXIMUM_VALID_MARK = 100;
  private static final int TOTAL_OF_ASSESSMENT_WEIGHTS = 100;
  private static final String[] GRADES = {"FL","AE","PS","CR","DI","HD"};

  private String unitCode_;
  private String unitName_;

  private float minimumMarkForPass_;
  private float minimumMarkForCredit_;
  private float minimumMarkForDistinction_;
  private float minimumMarkForHighDistinction_;

  private float minimumMarkForAdditionalExamination_;

  private int weightOfAssignmentOne_;
  private int weightOfAssignmentTwo_;
  private int weightOfExam_;

  private StudentUnitRecordList allStudentUnitRecords_;



  //============================================================================
  // Constructors
  //============================================================================



  /**
   * Creates a new unit instance, applying specified marks required for grades
   * and weightings for assessments and references the collection of student
   * records.
   * @param unitCode String
   *        This unit's code.
   * @param unitName String
   *        This unit's name.
   * @param minimumMarkForPass float
   *        Minimum mark to obtain a Pass grade in this unit.
   * @param minimumMarkForCredit float
   *        Minimum mark to obtain a Credit grade in this unit.
   * @param minimumMarkForDistinction float
   *        Minimum mark to obtain a Distinction grade in this unit.
   * @param minimumMarkForHighDistinction float
   *        Minimum mark to obtain a High Distinction grade in this unit.
   * @param minimumMarkForAdditionalExamination float
   *        Minimum mark to qualify for an Alternative Assessment in this unit.
   * @param weightOfAssignmentOne int
   *        Weight of assessment one result in grade calculation for this unit.
   * @param weightOfAssignmentTwo int
   *        Weight of assessment two result in grade calculation for this unit.
   * @param weightOfExam int
   *        Weight of the exam result in grade calculation for this unit.
   * @param studentUnitRecordList StudentUnitRecordList
   *        Collection of student records for this unit.
   */
  public Unit(String unitCode, String unitName,
              float minimumMarkForPass, float minimumMarkForCredit,
              float minimumMarkForDistinction,
              float minimumMarkForHighDistinction,
              float minimumMarkForAdditionalExamination,
              int weightOfAssignmentOne, int weightOfAssignmentTwo,
              int weightOfExam, StudentUnitRecordList studentUnitRecordList)
  {
    this.setUnitCode(unitCode);
    this.setUnitName(unitName);

    this.setMinimumMarksForGrades(minimumMarkForPass, minimumMarkForCredit,
                                  minimumMarkForDistinction,
                                  minimumMarkForHighDistinction,
                                  minimumMarkForAdditionalExamination);

    this.setWeightsOfAssessments(weightOfAssignmentOne, weightOfAssignmentTwo,
                                 weightOfExam);

    if (studentUnitRecordList == null) {
      studentUnitRecordList = new StudentUnitRecordList();
    }
    this.setAllStudentUnitRecords(studentUnitRecordList);
  }



  //============================================================================
  // Getters & setters
  //============================================================================



  /**
   * {@inheritDoc}
   */
  @Override
  public String getUnitCode() {
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
    return this.minimumMarkForAdditionalExamination_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForPass()
  {
    return this.minimumMarkForPass_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForCredit()
  {
    return this.minimumMarkForCredit_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForDistinction()
  {
    return this.minimumMarkForDistinction_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public float getMinimumMarkForHighDistinction()
  {
    return this.minimumMarkForHighDistinction_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentOne()
  {
    return this.weightOfAssignmentOne_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfAssignmentTwo()
  {
    return this.weightOfAssignmentTwo_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public int getWeightOfExam()
  {
    return this.weightOfExam_;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    for (IStudentUnitRecord studentUnitRecord :
        this.getAllStudentUnitRecords()) {
      if (studentUnitRecord.getStudentId() == studentId)
        return studentUnitRecord;
    }
    return null;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getAllStudentUnitRecords()
  {
    return this.allStudentUnitRecords_;
  }



  /**
   *
   */
  private void setUnitCode(String unitCode) {
    this.unitCode_ = unitCode;
  }



  /**
   *
   */
  private void setUnitName(String unitName)
  {
    this.unitName_ = unitName;
  }



  /**
   *
   */
  private void setAllStudentUnitRecords(StudentUnitRecordList
                                        allStudentUnitRecords)
  {
    this.allStudentUnitRecords_ = allStudentUnitRecords;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForAdditionalExamination(float minimumMark)
  {
    this.minimumMarkForAdditionalExamination_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForPass(float minimumMark)
  {
    this.minimumMarkForPass_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForCredit(float minimumMark)
  {
    this.minimumMarkForCredit_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForDistinction(float minimumMark)
  {
    this.minimumMarkForDistinction_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setMinimumMarkForHighDistinction(float minimumMark)
  {
    this.minimumMarkForHighDistinction_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void setWeightsOfAssessments(int weightOfAssignmentOne,
                                      int weightOfAssignmentTwo,
                                      int weightOfExam)
  {
    int[] weightsForAssessments = {weightOfAssignmentOne,
                                   weightOfAssignmentTwo, weightOfExam};

    int totalOfAssessmentWeights = weightOfAssignmentOne +
                                   weightOfAssignmentTwo + weightOfExam;


    throwIfWeightsOfAssessmentsAreOutsideValidRange( weightsForAssessments );
    throwIfTotalOfAssessmentWeightsIsInvalid(totalOfAssessmentWeights);

    this.weightOfAssignmentOne_ = weightOfAssignmentOne;
    this.weightOfAssignmentTwo_ = weightOfAssignmentTwo;
    this.weightOfExam_ = weightOfExam;
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
    float totalMark = markForAssignmentOne + markForAssignmentTwo + markForExam;

    float[] marksForAssessments = new float[]{markForAssignmentOne,
                                              markForAssignmentTwo,
                                              markForExam};

    throwIfMarksForAssessmentsAreInvalid(marksForAssessments);

    return compareTotalMarkToGradeMinimums(totalMark);
  }



  /**
   *
   */
  private void throwIfMarksForAssessmentsAreInvalid(float[] marksForAssessments)
  {
    boolean markIsLessThanMinimumValidMark;
    boolean markIsGreaterThanAssessmentWeight;
    float[] weightsOfAssessments = getWeightsOfAssessments();

    for (int i = 0; i < marksForAssessments.length; i++) {

      markIsLessThanMinimumValidMark =
        marksForAssessments[i] < MINIMUM_VALID_MARK;
      markIsGreaterThanAssessmentWeight =
        marksForAssessments[i] > weightsOfAssessments[i];

      if (markIsLessThanMinimumValidMark || markIsGreaterThanAssessmentWeight) {
        throw new RuntimeException( "marks cannot be less than zero or " +
                                      "greater than assessment weights" );
      }
    }
  }



  /**
   *
   */
  private float[] getWeightsOfAssessments()
  {
    return new float[]{getWeightOfAssignmentOne(), getWeightOfAssignmentTwo(),
                         getWeightOfExam()};
  }



  /**
   *
   */
  private float[] getMinimumMarksForGrades()
  {
    return new float[]{getMinimumMarkForAdditionalExamination(),
                       getMinimumMarkForPass(),
                       getMinimumMarkForCredit(),
                       getMinimumMarkForDistinction(),
                       getMinimumMarkForHighDistinction()};
  }



  /**
   *
   */
  private String compareTotalMarkToGradeMinimums( float totalMark ) {
    float[] minimumMarksForGrades = getMinimumMarksForGrades();
    for (int i = 0; i < minimumMarksForGrades.length; i++) {
      if (totalMark < minimumMarksForGrades[i]) {
        // Grade will be one position lower than minimum mark for next grade
        // meaning GRADE[i] is achieved if totalMark < minimumMarkForGrades[i]
        return GRADES[i];
      }
    }
    return GRADES[GRADES.length - 1]; // return highest grade
  }


  
  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
  {
    this.getAllStudentUnitRecords().add(studentUnitRecord);
  }



  /**
   * Checks the minimum marks specified for each grade are within bounds and
   * do not overlap.
   * @param minimumMarkForPass float
   *        Minimum mark to obtain a Pass grade in this unit.
   * @param minimumMarkForCredit float
   *        Minimum mark to obtain a Credit grade in this unit.
   * @param minimumMarkForDistinction float
   *        Minimum mark to obtain a Distinction grade in this unit.
   * @param minimumMarkForHighDistinction float
   *        Minimum mark to obtain a High Distinction grade in this unit.
   * @param minimumMarkForAdditionalExamination float
   *        Minimum mark to qualify for an Alternative Assessment in this unit.
   */
  private void setMinimumMarksForGrades(float minimumMarkForPass,
               float minimumMarkForCredit, float minimumMarkForDistinction,
               float minimumMarkForHighDistinction,
               float minimumMarkForAdditionalExamination)
  {
    // note minimumMarkForAdditionalExamination is first in array as it
    // is (or should be) the lowest mark in the set of marks
    float[] minimumMarksForGrades = new float[]{
            minimumMarkForAdditionalExamination, minimumMarkForPass,
            minimumMarkForCredit, minimumMarkForDistinction,
            minimumMarkForHighDistinction};

    throwIfMarksAreOutsideValidRange( minimumMarksForGrades );

    throwIfMinimumMarkForGradeHigherThanNextGrade(minimumMarksForGrades);

    this.setMinimumMarkForPass(minimumMarkForPass);
    this.setMinimumMarkForCredit(minimumMarkForCredit);
    this.setMinimumMarkForDistinction(minimumMarkForDistinction);
    this.setMinimumMarkForHighDistinction(minimumMarkForHighDistinction);
    this.setMinimumMarkForAdditionalExamination(
         minimumMarkForAdditionalExamination);
  }



  /**
   *
   */
  private void throwIfMinimumMarkForGradeHigherThanNextGrade(
               float[] minimumMarksForGrades)
  {
    for (int i = 0; i < minimumMarksForGrades.length - 1; i++) {

      // compare current grade minimum mark to next grade minimum grade
      // actual grade is one position higher in its array (as there is no
      // minimum mark for a FL
      if (minimumMarksForGrades[i] >= minimumMarksForGrades[i+1]) {
        throw new RuntimeException(GRADES[i+1] + " cutoff must be less than " +
                                   GRADES[i+2] + " cutoff");
      }
    }
  }



  /**
   *
   */
  private void throwIfMarksAreOutsideValidRange(float[] minimumMarksForGrades)
  {
    for (int i = 0; i < minimumMarksForGrades.length; i++) {

      if (isMarkOutsideValidRange(minimumMarksForGrades[i])) {
        throw new RuntimeException("Assessment cutoffs cant be less than zero" +
                                   " or greater than 100");
      }
    }
  }



  /**
   *
   */
  private void throwIfWeightsOfAssessmentsAreOutsideValidRange(
               int[] weightsForAssessments)
  {
    for (int i = 0; i < weightsForAssessments.length; i++) {

      // cast int to float in order to reuse helper method
      if (isMarkOutsideValidRange((float)weightsForAssessments[i])) {
        throw new RuntimeException("Assessment weights cant be less than " +
                                     "zero or greater than 100");
      }
    }
  }



  /**
   *
   */
  private boolean isMarkOutsideValidRange(float markForAssessment)
  {
    boolean isLowerThanMinimumValidMark =
      markForAssessment < MINIMUM_VALID_MARK;
    boolean isGreaterThanMaximumValidMark
      = markForAssessment > MAXIMUM_VALID_MARK;

    return isLowerThanMinimumValidMark || isGreaterThanMaximumValidMark;
  }



  private void throwIfTotalOfAssessmentWeightsIsInvalid(
               int totalOfAssessmentWeights)
  {
    if (totalOfAssessmentWeights != TOTAL_OF_ASSESSMENT_WEIGHTS) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
  }

}