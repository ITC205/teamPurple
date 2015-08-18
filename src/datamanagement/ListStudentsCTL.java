package datamanagement;
        public class ListStudentsCTL {
private StudentManager sm;
public ListStudentsCTL() {sm = StudentManager.getInstance();}
            public void listStudents( IStudentLister lister, String unitCode ) {
    lister.clearStudentsFromComboBox();
                StudentMap students = sm.findStudentsByUnit(unitCode);
for (Integer id : students.keySet() ) lister.addStudentToComboBox(students.get(id));}}
