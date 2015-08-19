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
  
  
  
  public void initialize()
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



  public void unitSelectedHandler(String unitCode)
  {

    if (unitCode.equals("NONE")) {
      userInterface_.setSelectStudentComboBoxEnabled(false);
    }
    else {
      ListStudentsController listStudentsController = 
                                  new ListStudentsController();
      
      listStudentsController.listStudents(userInterface_, unitCode);
      currentUnitCode_ = unitCode;
      userInterface_.setSelectStudentComboBoxEnabled(true);
    }
    userInterface_.setCheckGradeButtonEnabled(false);
  }



  public void studentSelectedHandler(Integer studentId)
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
      IStudent student = StudentManager.getInstance().findStudent(studentId);
      IStudentUnitRecord studentUnitRecord = student
                                             .retrieveStudentUnitRecord(currentUnitCode_);

      userInterface_.setStudentUnitRecord(studentUnitRecord);
      userInterface_.setCheckGradeButtonEnabled(true);
      userInterface_.setChangeButtonEnabled(true);
      userInterface_.setMarkEntryTextFieldsEnabled(false);
      userInterface_.setSaveButtonEnabled(false);

      isChangesMade_ = false;
    }
  }



  public String checkGradeHandler(float markForAssignmentOne,
                                  float markForAssignmentTwo, float markForExam)
  {
    IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
    String grade = unit.calculateGrade(markForAssignmentOne,
                                       markForAssignmentTwo, markForExam);

    userInterface_.setChangeButtonEnabled(true);
    userInterface_.setMarkEntryTextFieldsEnabled(false);

    if (isChangesMade_) {
      userInterface_.setSaveButtonEnabled(true);
    }
    return grade;
  }


  
  public void saveGradeHandler(float markForAssignmentOne, 
                               float markForAssignmentTwo, float markForExam)
  {

    IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
    IStudent student = StudentManager.getInstance().findStudent(currentStudentId_);
    IStudentUnitRecord studentUnitrecord = student
                                           .retrieveStudentUnitRecord(currentUnitCode_);

    studentUnitrecord.setMarkForAssignmentOne(markForAssignmentOne);
    studentUnitrecord.setMarkForAssignmentTwo(markForAssignmentTwo);
    studentUnitrecord.setMarkForExam(markForExam);

    StudentUnitRecordManager.getInstance().saveStudentUnitRecord(studentUnitrecord);
    userInterface_.setChangeButtonEnabled(true);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
  }
  
  
  
  public void enableChangeMarks()
  {
    userInterface_.setChangeButtonEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
    userInterface_.setMarkEntryTextFieldsEnabled(true);
    
    isChangesMade_ = true;
  }
}
