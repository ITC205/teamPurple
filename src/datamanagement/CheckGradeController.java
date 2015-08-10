package datamanagement;

public class CheckGradeController
{
  // ===========================================================================
  // Variables
  // ===========================================================================
  
  
  
  private CheckGradeUserInterface userInterface_;
  private String currentUnitCode_ = null;
  private Integer currentStudentId_ = null;
  private boolean isChangesMade_ = false;

  

  // ===========================================================================
  // Constructors
  // ===========================================================================
  
  
  
  public CheckGradeController()
  {
  }


  
  // ===========================================================================
  // Methods
  // ===========================================================================
  
  
  
  public void execute()
  {
    userInterface_ = new CheckGradeUserInterface(this);
    ListUnitsCTL listUnitsController = new ListUnitsCTL();
    
    userInterface_.setSelectUnitComboBoxEnabled(false);
    userInterface_.setSelectStudentComboBoxEnabled(false);
    userInterface_.setCheckGradeButtonEnabled(false);
    userInterface_.setChangeButtonEnabled(false);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
    userInterface_.clearDisplayedText();

    listUnitsController.listUnits(userInterface_);
    userInterface_.setVisible(true);
    userInterface_.setSelectUnitComboBoxEnabled(true);
  }



  public void unitSelected(String unitCode)
  {

    if (unitCode.equals("NONE")) {
      userInterface_.setSelectStudentComboBoxEnabled(false);
    }
    else {
      ListStudentsCTL listStudentsController = new ListStudentsCTL();
      
      listStudentsController.listStudents(userInterface_, unitCode);
      currentUnitCode_ = unitCode;
      userInterface_.setSelectStudentComboBoxEnabled(true);
    }
    userInterface_.setCheckGradeButtonEnabled(false);
  }



  public void studentSelected(Integer studentId)
  {
    currentStudentId_ = studentId;
    
    if (currentStudentId_.intValue() == 0) {
      userInterface_.clearDisplayedText();
      userInterface_.setCheckGradeButtonEnabled(false);
      userInterface_.setChangeButtonEnabled(false);
      userInterface_.setMarkEntryTextFieldsEnabled(false);
      userInterface_.setSaveButtonEnabled(false);
    }

    else {
      IStudent student = StudentManager.get().getStudent(studentId);
      IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);

      userInterface_.setRecord(record);
      userInterface_.setCheckGradeButtonEnabled(true);
      userInterface_.setChangeButtonEnabled(true);
      userInterface_.setMarkEntryTextFieldsEnabled(false);
      userInterface_.setSaveButtonEnabled(false);
      
      isChangesMade_ = false;
    }
  }



  public String checkGrade(float assessmentOneMark, float assessmentTwoMark,
          float examMark)
  {
    IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
    String grade = unit.calculateGrade(assessmentOneMark, assessmentTwoMark, examMark);
    
    userInterface_.setChangeButtonEnabled(true);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    
    if (isChangesMade_) {
      userInterface_.setSaveButtonEnabled(true);
    }
    return grade;
  }



  public void enableChangeMarks()
  {
    userInterface_.setChangeButtonEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
    userInterface_.setMarkEntryTextFieldsEnabled(true);
    
    isChangesMade_ = true;
  }



  public void saveGrade(float assessmentOneMark, float assessmentTwoMark, float examMark)
  {

    IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
    IStudent student = StudentManager.get().getStudent(currentStudentId_);
    IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);
    
    record.setAssessmentOneMark(assessmentOneMark);
    record.setAssessmentTwoMark(assessmentTwoMark);
    record.setExamMark(examMark);
    
    StudentUnitRecordManager.getInstance().saveRecord(record);
    userInterface_.setChangeButtonEnabled(true);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
  }
}
