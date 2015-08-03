package datamanagement;

/**
 * Unit
 */
public interface IUnit
{
  // TODO: should all javadoc actually be here???
  public String calculateGrade(float assignmentOneMark,
                               float assignmentTwoMark,
                               float examMark);

  public void addStudentRecord(IStudentUnitRecord studentUnitRecord);

  public String getUnitCode();
  public String getUnitName();

  public float getAdditionalExaminationMinimumMark();
  public float getPassMinimumMark();
  public float getCreditMinimumMark();
  public float getDistinctionMinimumMark();
  public float getHighDistinctionMinimumMark();

  public int getAssignmentOneWeight();
  public int getAssignmentTwoWeight();
  public int getExamWeight();

  public IStudentUnitRecord getStudentUnitRecord(int studentId);
  public StudentUnitRecordList getStudentUnitRecords();

  public void setAdditionalExaminationMinimumMark(float mark);
  public void setPassMinimumMark(float mark);
  public void setCreditMinimumMark(float mark);
  public void setDistinctionMinimumMark(float mark);
  public void setHighDistinctionMinimumMark(float mark);

  // TODO: rename to applyAssessmentWeights() ???
  public void setAssessmentWeights(int assignmentOneWeight,
                                   int assignmentTwoWeight,
                                   int examWeight);
}
