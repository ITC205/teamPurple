package datamanagement;

public class StudentUnitRecordProxy 
  implements IStudentUnitRecord
{
  // ===========================================================================
  // Variables
  // ===========================================================================



  private Integer studentId_;
  private String unitCode_;
  private StudentUnitRecordManager manager_;



  // ===========================================================================
  // Constructors
  // ===========================================================================



  public StudentUnitRecordProxy(Integer studentId, String unitCode)
  {
    studentId_ = studentId;
    unitCode_ = unitCode;
    manager_ = StudentUnitRecordManager.getInstance();
  }



  // ===========================================================================
  // Getters & setters
  // ===========================================================================



  public Integer getStudentId()
  {
    return studentId_;
  }



  public String getUnitCode()
  {
    return unitCode_;
  }



  public float getMarkForAssignmentOne()
  {

    return manager_.findStudentUnitRecord(studentId_, unitCode_)
                   .getMarkForAssignmentOne();
  }



  public float getMarkForAssignmentTwo()
  {
    return manager_.findStudentUnitRecord(studentId_, unitCode_)
                   .getMarkForAssignmentTwo();
  }



  public float getMarkForExam()
  {
    return manager_.findStudentUnitRecord(studentId_, unitCode_)
                   .getMarkForExam();
  }



  public void setMarkForAssignmentOne(float newMark)
  {
    manager_.findStudentUnitRecord(studentId_, unitCode_)
            .setMarkForAssignmentOne(newMark);
  }



  public void setMarkForAssignmentTwo(float newMark)
  {
    manager_.findStudentUnitRecord(studentId_, unitCode_)
            .setMarkForAssignmentTwo(newMark);
  }



  public void setMarkForExam(float newMark)
  {
    manager_.findStudentUnitRecord(studentId_, unitCode_)
            .setMarkForExam(newMark);
  }
  
  
  
  //===========================================================================
  // Methods
  //===========================================================================

  

  public float calculateTotalMark()
  {
    return manager_.findStudentUnitRecord(studentId_, unitCode_)
                   .calculateTotalMark();
  }
  
}
