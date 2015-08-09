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
    userInterface_.setSelectUnitComboBoxEnabled(false);

    userInterface_.setSelectStudentComboBoxEnabled(false);
    userInterface_.setCheckGradeButtonEnabled(false);
    userInterface_.setChangeButtonEnabled(false);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
    userInterface_.clearDisplayedText();

    ListUnitsCTL luCTL = new ListUnitsCTL();
    luCTL.listUnits(userInterface_);
    userInterface_.setVisible(true);
    userInterface_.setSelectUnitComboBoxEnabled(true);
  }



  public void unitSelected(String code)
  {

    if (code.equals("NONE"))
      userInterface_.setSelectStudentComboBoxEnabled(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(userInterface_, code);
      currentUnitCode_ = code;
      userInterface_.setSelectStudentComboBoxEnabled(true);
    }
    userInterface_.setCheckGradeButtonEnabled(false);
  }



  public void studentSelected(Integer id)
  {
    currentStudentId_ = id;
    if (currentStudentId_.intValue() == 0) {
      userInterface_.clearDisplayedText();
      userInterface_.setCheckGradeButtonEnabled(false);
      userInterface_.setChangeButtonEnabled(false);
      userInterface_.setMarkEntryTextFieldsEnabled(false);
      userInterface_.setSaveButtonEnabled(false);
    }

    else {
      IStudent s = StudentManager.get().getStudent(id);

      IStudentUnitRecord r = s.getUnitRecord(currentUnitCode_);

      userInterface_.setRecord(r);
      userInterface_.setCheckGradeButtonEnabled(true);
      userInterface_.setChangeButtonEnabled(true);
      userInterface_.setMarkEntryTextFieldsEnabled(false);
      userInterface_.setSaveButtonEnabled(false);
      isChangesMade_ = false;

    }
  }



  public String checkGrade(float f, float g, float h)
  {
    IUnit u = UnitManager.getInstance().getUnit(currentUnitCode_);
    String s = u.getGrade(f, g, h);
    userInterface_.setChangeButtonEnabled(true);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    if (isChangesMade_) {
      userInterface_.setSaveButtonEnabled(true);
    }
    return s;
  }



  public void enableChangeMarks()
  {
    userInterface_.setChangeButtonEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
    userInterface_.setMarkEntryTextFieldsEnabled(true);
    isChangesMade_ = true;
  }



  public void saveGrade(float asg1, float asg2, float exam)
  {

    IUnit u = UnitManager.getInstance().getUnit(currentUnitCode_);
    IStudent s = StudentManager.get().getStudent(currentStudentId_);

    IStudentUnitRecord r = s.getUnitRecord(currentUnitCode_);
    r.setAsg1(asg1);
    r.setAsg2(asg2);
    r.setExam(exam);
    StudentUnitRecordManager.instance().saveRecord(r);
    userInterface_.setChangeButtonEnabled(true);
    userInterface_.setMarkEntryTextFieldsEnabled(false);
    userInterface_.setSaveButtonEnabled(false);
  }
}
