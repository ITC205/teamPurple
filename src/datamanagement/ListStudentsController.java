package datamanagement;

public class ListStudentsController 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  
  
  private StudentManager studentList_;


  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  
  
  public ListStudentsController()
  {
    studentList_ = StudentManager.getInstance();
  }


  
  //===========================================================================
  // Methods: primary
  //===========================================================================
  
  
  
  public void listStudents(IStudentLister studentLister, String unitCode) 
  {
    studentLister.clearStudentsFromComboBox();
    StudentMap studentsByUnit = studentList_.findStudentsByUnit(unitCode);
    
    for (Integer studentId : studentsByUnit.keySet() ) {
      studentLister.addStudentToComboBox(studentsByUnit.get(studentId));
    }
  }

}
