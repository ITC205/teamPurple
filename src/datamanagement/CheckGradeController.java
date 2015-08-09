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
    userInterface_.setState1(false);

    userInterface_.setState2(false);
    userInterface_.setState3(false);
    userInterface_.setState4(false);
    userInterface_.setState5(false);
    userInterface_.setState6(false);
    userInterface_.Refresh3();

    ListUnitsCTL luCTL = new ListUnitsCTL();
    luCTL.listUnits(userInterface_);
    userInterface_.setVisible(true);
    userInterface_.setState1(true);
  }



  public void unitSelected(String code)
  {

    if (code.equals("NONE"))
      userInterface_.setState2(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(userInterface_, code);
      currentUnitCode_ = code;
      userInterface_.setState2(true);
    }
    userInterface_.setState3(false);
  }



  public void studentSelected(Integer id)
  {
    currentStudentId_ = id;
    if (currentStudentId_.intValue() == 0) {
      userInterface_.Refresh3();
      userInterface_.setState3(false);
      userInterface_.setState4(false);
      userInterface_.setState5(false);
      userInterface_.setState6(false);
    }

    else {
      IStudent s = StudentManager.get().getStudent(id);

      IStudentUnitRecord r = s.getUnitRecord(currentUnitCode_);

      userInterface_.setRecord(r);
      userInterface_.setState3(true);
      userInterface_.setState4(true);
      userInterface_.setState5(false);
      userInterface_.setState6(false);
      isChangesMade_ = false;

    }
  }



  public String checkGrade(float f, float g, float h)
  {
    IUnit u = UnitManager.getInstance().getUnit(currentUnitCode_);
    String s = u.getGrade(f, g, h);
    userInterface_.setState4(true);
    userInterface_.setState5(false);
    if (isChangesMade_) {
      userInterface_.setState6(true);
    }
    return s;
  }



  public void enableChangeMarks()
  {
    userInterface_.setState4(false);
    userInterface_.setState6(false);
    userInterface_.setState5(true);
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
    userInterface_.setState4(true);
    userInterface_.setState5(false);
    userInterface_.setState6(false);
  }
}
