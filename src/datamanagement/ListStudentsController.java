package datamanagement;

public class ListStudentsController 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  
  
  private StudentManager studentManager_;


  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  
  
  public ListStudentsController()
  {
    studentManager_ = StudentManager.getInstance();
  }


  
  //===========================================================================
  // Methods
  //===========================================================================
  
  
  
  public void listStudents(IStudentLister studentLister, String unitCode) 
  {
    studentLister.clearStudentsFromComboBox();
    StudentMap studentsByUnit = studentManager_.findStudentsByUnit(unitCode);
    
    for (Integer studentId : studentsByUnit.keySet() ) {
      studentLister.addStudentToComboBox(studentsByUnit.get(studentId));
    }
  }

}
