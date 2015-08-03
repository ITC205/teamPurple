package datamanagement;

/**
*
*/
public class Unit implements IUnit
{
  //===========================================================================
  // Variables
  //===========================================================================

  //TODO: Variables - correct name?

  private static final String GRADE_FAIL = "FL";
  private static final String GRADE_ADDITIONAL_EXAMINATION = "AE";
  private static final String GRADE_PASS = "PS";
  private static final String GRADE_CREDIT = "CR";
  private static final String GRADE_DISTINCTION = "DI";
  private static final String GRADE_HIGH_DISTINCTION = "HD";



  private String unitCode_;
  private String unitName_;

  private float additionalExaminationMinimumMark_;  // additionalExaminationCutoffMark_ // cutoff used in UI descriptions
  private float passMinimumMark_;
  private float creditMinimumMark_;
  private float distinctionMinimumMark_;
  private float highDistinctionMinimumMark_;

  private int assignmentOneWeight_;
  private int assignmentTwoWeight_;
  private int examWeight_;

  private StudentUnitRecordList studentUnitRecordList_; //studentUnitRecords ???



  //===========================================================================
  // Constructors
  //===========================================================================

  public Unit(String unitCode, String unitName,
              float additionalExaminationMinimumMark, float passMinimumMark,
              float creditMinimumMark, float distinctionMinimumMark,
              float highDistinctionMinimumMark,
              int assignmentOneWeight, int assignmentTwoWeight, int examWeight,
              StudentUnitRecordList StudentUnitRecordList) {

    this.unitCode_ = unitCode;
    this.unitName_ = unitName;

    this.additionalExaminationMinimumMark_ = additionalExaminationMinimumMark;
    this.passMinimumMark_ = passMinimumMark;
    this.creditMinimumMark_ = creditMinimumMark;
    this.distinctionMinimumMark_ = distinctionMinimumMark;
    this.highDistinctionMinimumMark_ = highDistinctionMinimumMark;

    this.setAssessmentWeights(assignmentOneWeight, assignmentTwoWeight,
                              examWeight);

    if (StudentUnitRecordList == null) {
      StudentUnitRecordList = new StudentUnitRecordList();
    }
    this.studentUnitRecordList_ = StudentUnitRecordList;
  }



  public String calculateGrade(float assignmentOneMark, float assignmentTwoMark,
                               float examMark) {

    float totalMark = assignmentOneMark + assignmentTwoMark + examMark;

    if ((assignmentOneMark < 0 || assignmentOneMark > assignmentOneWeight_) ||
        (assignmentTwoMark < 0 || assignmentTwoMark > assignmentTwoWeight_) ||
        (examMark < 0          || examMark > examWeight_)) {
      throw new RuntimeException("marks cannot be less than zero or greater " +
                                 "than assessment weights" );
    }

    if (totalMark < this.getAdditionalExaminationMinimumMark()) {
      return GRADE_FAIL;
    } else if (totalMark < this.getPassMinimumMark()) {
      return GRADE_ADDITIONAL_EXAMINATION;
    } else if (totalMark < this.getCreditMinimumMark()) {
      return GRADE_PASS;
    } else if (totalMark < this.getDistinctionMinimumMark()) {
      return GRADE_CREDIT;
    } else if (totalMark < this.getHighDistinctionMinimumMark()) {
      return GRADE_DISTINCTION;
    } else {
      return GRADE_HIGH_DISTINCTION;
    }
  }



  public void addStudentRecord(IStudentUnitRecord record) {
    this.getStudentUnitRecords().add(record);
  }



  public String getUnitCode() {
    return this.unitCode_;
  }



  public String getUnitName() {
    return this.unitName_;
  }



  public float getAdditionalExaminationMinimumMark() {
    return this.additionalExaminationMinimumMark_;
  }



  public float getPassMinimumMark() {
    return this.passMinimumMark_;
  }



  public float getCreditMinimumMark() {
    return this.creditMinimumMark_;
  }



  public float getDistinctionMinimumMark() {
    return this.distinctionMinimumMark_;
  }



  public float getHighDistinctionMinimumMark() {
    return this.highDistinctionMinimumMark_;
  }



  @Override
  public int getAssignmentOneWeight() {
    return this.assignmentOneWeight_;
  }



  @Override
  public int getAssignmentTwoWeight() {
    return this.assignmentTwoWeight_;
  }



  @Override
  public int getExamWeight() {
    return this.examWeight_;
  }



  public IStudentUnitRecord getStudentUnitRecord(int studentId) {
    for (IStudentUnitRecord record : this.getStudentUnitRecords()) {
      if (record.getStudentId() == studentId) {
        return record;
      }
    }
    return null;
  }



  public StudentUnitRecordList getStudentUnitRecords() {
    return this.studentUnitRecordList_;
  }



  public void setAdditionalExaminationMinimumMark(float mark) {
    this.additionalExaminationMinimumMark_ = mark;
  }



  public void setPassMinimumMark(float mark) {
    this.passMinimumMark_ = mark;
  }



  public void setCreditMinimumMark(float mark) {
    this.creditMinimumMark_ = mark;
  }



  public void setDistinctionMinimumMark(float mark) {
    this.distinctionMinimumMark_ = mark;
  }



  public void setHighDistinctionMinimumMark(float mark) {
    this.highDistinctionMinimumMark_ = mark;
  }



  @Override
  public void setAssessmentWeights(int assignmentOneWeight,
                                   int assignmentTwoWeight, int examWeight) {

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



  private void setCutoffs(float alternativeAssessmentMinimumMark,
                          float passMinimumMark, float creditMinimumMark,
                          float distinctionMinimumMark,
                          float highDistinctionMinimumMark) {
    // could refactor for range check
    if ((alternativeAssessmentMinimumMark < 0 ||
             alternativeAssessmentMinimumMark > 100) ||
        (passMinimumMark < 0            || passMinimumMark > 100) ||
        (creditMinimumMark < 0          || creditMinimumMark > 100) ||
        (distinctionMinimumMark < 0     || distinctionMinimumMark > 100) ||
        (highDistinctionMinimumMark < 0 || highDistinctionMinimumMark > 100)) {
      throw new RuntimeException( "Assessment cutoffs cant be less than zero or greater than 100");
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



}