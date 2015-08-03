package datamanagement;

/**
 * default implementation of IUnit interface
 * applies the specified minimum marks (for grades) and weightings for
 * assessments to this unit
 */
public class Unit
  implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  private static final String GRADE_FAIL = "FL";                    // new
  private static final String GRADE_ADDITIONAL_EXAMINATION = "AE";
  private static final String GRADE_PASS = "PS";
  private static final String GRADE_CREDIT = "CR";
  private static final String GRADE_DISTINCTION = "DI";
  private static final String GRADE_HIGH_DISTINCTION = "HD";

  private String unitCode_;
  private String unitName_;

  // TODO: - names? additionalExaminationCutoffMark_
  // TODO: suffix cutoff used in UI descriptions
  private float additionalExaminationMinimumMark_;
  private float passMinimumMark_;
  private float creditMinimumMark_;
  private float distinctionMinimumMark_;
  private float highDistinctionMinimumMark_;

  private int assignmentOneWeight_;
  private int assignmentTwoWeight_;
  private int examWeight_;

  private StudentUnitRecordList studentUnitRecords_; // not List

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates a new unit
   */
  public Unit(String unitCode, String unitName,
              float passMinimumMark, float creditMinimumMark,
              float distinctionMinimumMark, float highDistinctionMinimumMark,
              float additionalExaminationMinimumMark,
              int assignmentOneWeight, int assignmentTwoWeight, int examWeight,
              StudentUnitRecordList studentUnitRecordList)
  {
    // TODO: this. is not needed due to _ suffix
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;

    this.setAdditionalExaminationMinimumMark(additionalExaminationMinimumMark);
    this.setPassMinimumMark(passMinimumMark);
    this.setCreditMinimumMark(creditMinimumMark);
    this.setDistinctionMinimumMark(distinctionMinimumMark);
    this.setHighDistinctionMinimumMark( highDistinctionMinimumMark );

    this.setAssessmentWeights(assignmentOneWeight, assignmentTwoWeight,
                              examWeight);

    if (studentUnitRecordList == null) {
      studentUnitRecordList = new StudentUnitRecordList();
    }
    this.studentUnitRecords_ = studentUnitRecordList;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * returns correct grade for the unit (accounting for marks and weightings)
   * @param assignmentOneMark student mark (float) for assignment one
   * @param assignmentTwoMark  student mark (float) for assignment two
   * @param examMark  student mark (float) for the exam
   * @return student's grade for unit (String)
   */
  @Override
  public String calculateGrade(float assignmentOneMark, float assignmentTwoMark,
                               float examMark)
  {
    float totalMark = assignmentOneMark + assignmentTwoMark + examMark;
    String studentGrade = "";

    if ((assignmentOneMark < 0 || assignmentOneMark > assignmentOneWeight_) ||
        (assignmentTwoMark < 0 || assignmentTwoMark > assignmentTwoWeight_) ||
        (examMark < 0          || examMark > examWeight_)) {
      throw new RuntimeException("marks cannot be less than zero or greater " +
                                 "than assessment weights" );
    }

    if (totalMark < this.getAdditionalExaminationMinimumMark()) {
      studentGrade = GRADE_FAIL;
    }
    else if (totalMark < this.getPassMinimumMark()) {
      studentGrade = GRADE_ADDITIONAL_EXAMINATION;
    }
    else if (totalMark < this.getCreditMinimumMark()) {
      studentGrade = GRADE_PASS;
    }
    else if (totalMark < this.getDistinctionMinimumMark()) {
      studentGrade = GRADE_CREDIT;
    }
    else if (totalMark < this.getHighDistinctionMinimumMark()) {
      studentGrade = GRADE_DISTINCTION;
    }
    else {
      studentGrade = GRADE_HIGH_DISTINCTION;
    }
    return studentGrade;
  }



/**
 *
 */
 private void checkMinimumMarks(float alternativeAssessmentMinimumMark,
                                 float passMinimumMark, float creditMinimumMark,
                                 float distinctionMinimumMark,
                                 float highDistinctionMinimumMark)
 {
    // could refactor for range check
    if ((alternativeAssessmentMinimumMark < 0 ||
           alternativeAssessmentMinimumMark > 100) ||
        (passMinimumMark < 0            || passMinimumMark > 100) ||
        (creditMinimumMark < 0          || creditMinimumMark > 100) ||
        (distinctionMinimumMark < 0     || distinctionMinimumMark > 100) ||
        (highDistinctionMinimumMark < 0 || highDistinctionMinimumMark > 100)) {
      throw new RuntimeException( "Assessment cutoffs cant be less than zero" +
                                    " or greater than 100");
    }

    if (alternativeAssessmentMinimumMark >= passMinimumMark) {
      throw new RuntimeException( "AE cutoff must be less than PS cutoff");
    }
    if (passMinimumMark >= creditMinimumMark) {
      throw new RuntimeException( "PS cutoff must be less than CR cutoff" );
    }
    if (creditMinimumMark >= distinctionMinimumMark) {
      throw new RuntimeException( "CR cutoff must be less than DI cutoff" );
    }
    if (distinctionMinimumMark >= highDistinctionMinimumMark) {
      throw new RuntimeException( "DI cutoff must be less than HD cutoff" );
    }
  }



  /**
   *
   */
  @Override
  public void addStudentRecord(IStudentUnitRecord record)
  {
    this.getStudentUnitRecords().add(record);
  }



  /**
   *
   */
  @Override
  public String getUnitCode()
  {
    return this.unitCode_;
  }



  /**
   *
   */
  @Override
  public String getUnitName()
  {
    return this.unitName_;
  }



  /**
   *
   */
  @Override
  public float getAdditionalExaminationMinimumMark()
  {
    return this.additionalExaminationMinimumMark_;
  }



  /**
   *
   */
  @Override
  public float getPassMinimumMark()
  {
    return this.passMinimumMark_;
  }



  /**
   *
   */
  @Override
  public float getCreditMinimumMark()
  {
    return this.creditMinimumMark_;
  }



  /**
   *
   */
  @Override
  public float getDistinctionMinimumMark()
  {
    return this.distinctionMinimumMark_;
  }



  /**
   *
   */
  @Override
  public float getHighDistinctionMinimumMark()
  {
    return this.highDistinctionMinimumMark_;
  }



  /**
   *
   */
  @Override
  public int getAssignmentOneWeight()
  {
    return this.assignmentOneWeight_;
  }



  /**
   *
   */
  @Override
  public int getAssignmentTwoWeight()
  {
    return this.assignmentTwoWeight_;
  }



  /**
   *
   */
  @Override
  public int getExamWeight()
  {
    return this.examWeight_;
  }



  /**
   *
   */
  @Override
  public IStudentUnitRecord getStudentUnitRecord(int studentId)
  {
    for (IStudentUnitRecord record : this.getStudentUnitRecords()) {
      if (record.getStudentID() == studentId) {
        return record;
      }
    }
    return null;
  }



  /**
   *
   */
  @Override
  public StudentUnitRecordList getStudentUnitRecords()
  {
    return this.studentUnitRecords_;
  }



  /**
   *
   */
  @Override
  public void setAdditionalExaminationMinimumMark(float mark)
  {
    this.additionalExaminationMinimumMark_ = mark;
  }



  /**
   *
   */
  @Override
  public void setPassMinimumMark(float mark)
  {
    this.passMinimumMark_ = mark;
  }



  /**
   *
   */
  @Override
  public void setCreditMinimumMark(float mark)
  {
    this.creditMinimumMark_ = mark;
  }



  /**
   *
   */
  @Override
  public void setDistinctionMinimumMark(float mark)
  {
    this.distinctionMinimumMark_ = mark;
  }



  /**
   *
   */
  public void setHighDistinctionMinimumMark(float mark)
  {
    this.highDistinctionMinimumMark_ = mark;
  }



  /**
   *
   */
  @Override
  public void setAssessmentWeights(int assignmentOneWeight,
                                   int assignmentTwoWeight, int examWeight)
  {
    if ((assignmentOneWeight < 0 || assignmentOneWeight > 100) ||
        (assignmentTwoWeight < 0 || assignmentTwoWeight > 100) ||
        (examWeight < 0          || examWeight > 100)) {
      throw new RuntimeException("Assessment weights cant be less than " +
                                 "zero or greater than 100" );
    }

    // TODO: will 3 floats cause rounding errors???
    if (assignmentOneWeight + assignmentTwoWeight + examWeight != 100) {
      throw new RuntimeException("Assessment weights must add to 100");
    }

    this.assignmentOneWeight_ = assignmentOneWeight;
    this.assignmentTwoWeight_ = assignmentTwoWeight;
    this.examWeight_ = examWeight;
  }


}