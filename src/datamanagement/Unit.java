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
  //===========================================================================
  // Variables
  //===========================================================================

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

  private StudentUnitRecordList studentUnitRecordList_;

  //===========================================================================
  // Constructors
  //===========================================================================

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
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;

    this.minimumMarkForPass_ = minimumMarkForPass;
    this.minimumMarkForCredit_ = minimumMarkForCredit;
    this.minimumMarkForDistinction_ = minimumMarkForDistinction;
    this.minimumMarkForHighDistinction_ = minimumMarkForHighDistinction;

    this.minimumMarkForAdditionalExamination_ =
        minimumMarkForAdditionalExamination;

    this.setWeightsOfAssessments(weightOfAssignmentOne, weightOfAssignmentTwo,
                                 weightOfExam);

    this.studentUnitRecordList_ = studentUnitRecordList == null ? new StudentUnitRecordList() : studentUnitRecordList;
  }


  //===========================================================================
  // Getters & setters
  //===========================================================================

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
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    for (IStudentUnitRecord studentUnitRecord : this.studentUnitRecordList_) {
      if (studentUnitRecord.getStudentID() == studentId)
        return studentUnitRecord;
    }
    return null;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public StudentUnitRecordList getStudentUnitRecordList()
  {
    return this.studentUnitRecordList_;
  }



  /**
   * {@inheritDoc}
   */
  public void setMinimumMarkForAdditionalExamination(float minimumMark)
  {
    this.minimumMarkForAdditionalExamination_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
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
  public void setMinimumMarkForDistinction(float minimumMark)
  {
    this.minimumMarkForDistinction_ = minimumMark;
  }



  /**
   * {@inheritDoc}
   */
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
    if ( weightOfAssignmentOne < 0 || weightOfAssignmentOne > 100 ||
          weightOfAssignmentTwo < 0 || weightOfAssignmentTwo > 100 ||
          weightOfExam < 0 || weightOfExam > 100 ) {
      throw new RuntimeException("Assessment weights cant be less than zero" +
                                   " or greater than 100");
    }
    if ( weightOfAssignmentOne + weightOfAssignmentTwo + weightOfExam != 100 ) {
      throw new RuntimeException("Assessment weights must add to 100");
    }
    this.weightOfAssignmentOne_ = weightOfAssignmentOne;
    this.weightOfAssignmentTwo_ = weightOfAssignmentTwo;
    this.weightOfExam_ = weightOfExam;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * {@inheritDoc}
   */
  @Override
  public String calculateGrade(float markForAssignmentOne,
                               float markForAssignmentTwo,
                               float markForExam)
  {
    float totalMark = markForAssignmentOne + markForAssignmentTwo +
                      markForExam;

    if (markForAssignmentOne < 0 || markForAssignmentOne > this.weightOfAssignmentOne_ ||
        markForAssignmentTwo < 0 || markForAssignmentTwo > this.weightOfAssignmentTwo_ ||
        markForExam < 0 || markForExam > this.weightOfExam_) {
      throw new RuntimeException("marks cannot be less than zero or greater" +
                                 " than assessment weights");
    }

    if (totalMark < minimumMarkForAdditionalExamination_ ) {
      return "FL";
    }
    else if (totalMark < minimumMarkForPass_ ) {
      return "AE";
    }
    else if (totalMark < minimumMarkForCredit_ ) {
      return "PS";
    }
    else if (totalMark < minimumMarkForDistinction_ ) {
      return "CR";
    }
    else if (totalMark < minimumMarkForHighDistinction_ ) {
      return "DI";
    }
    else {
      return "HD";
    }
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
  {
    this.studentUnitRecordList_.add(studentUnitRecord);
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
  private void setCutoffs(float minimumMarkForPass, float minimumMarkForCredit,
                          float minimumMarkForDistinction,
                          float minimumMarkForHighDistinction,
                          float minimumMarkForAdditionalExamination)
  {
    if (minimumMarkForPass < 0 || minimumMarkForPass > 100 ||
          minimumMarkForCredit < 0 || minimumMarkForCredit > 100 ||
          minimumMarkForDistinction < 0 || minimumMarkForDistinction > 100 ||
          minimumMarkForHighDistinction < 0 || minimumMarkForHighDistinction > 100 ||
          minimumMarkForAdditionalExamination < 0 || minimumMarkForAdditionalExamination > 100 ) {
      throw new RuntimeException("Assessment cutoffs cant be less than zero" +
                                   " or greater than 100");
    }
    if (minimumMarkForAdditionalExamination >= minimumMarkForPass) {
      throw new RuntimeException("AE cutoff must be less than PS cutoff");
    }
    if (minimumMarkForPass >= minimumMarkForCredit) {
      throw new RuntimeException("PS cutoff must be less than CR cutoff");
    }
    if (minimumMarkForCredit >= minimumMarkForDistinction) {
      throw new RuntimeException("CR cutoff must be less than DI cutoff");
    }
    if (minimumMarkForDistinction >= minimumMarkForHighDistinction) {
      throw new RuntimeException("DI cutoff must be less than HD cutoff");
    }



  }



}