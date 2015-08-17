package datamanagement;

public class ListStudentsCTL 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private StudentManager studentList_;


  //===========================================================================
  // Constructors
  //===========================================================================
  
  public ListStudentsCTL()
  {
    studentList_ = StudentManager.getInstance();
  }


  //===========================================================================
  // Methods: primary
  //===========================================================================
  
  public void listStudents(IStudentLister studentLister, String unitCode) 
  {
    studentLister.clearStudents();
    StudentMap students = studentList_.getStudentsByUnit(unitCode);
    
    for (Integer studentId : students.keySet() ) {
      studentLister.addStudent(students.get(studentId));
    }
  }



}
