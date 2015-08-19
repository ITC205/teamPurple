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
    StudentMap students = studentList_.findStudentsByUnit(unitCode);
    
    for (Integer studentId : students.keySet() ) {
      studentLister.addStudentToComboBox(students.get(studentId));
    }
  }

}
