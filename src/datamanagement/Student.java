package datamanagement;

<<<<<<< HEAD
public class Student implements IStudent 
{
  //===========================================================================
  // Variables
  //===========================================================================
  
  private Integer studentId_; 
  private String firstName_;
  private String lastName_;
  private StudentUnitRecordList allStudentUnitRecords_;

  
  //===========================================================================
  // Constructors
  //===========================================================================
  
  public Student(Integer studentId, String firstName, String lastName
                   , StudentUnitRecordList allStudentUnitRecords)
  { 
    studentId_ = studentId; 
    firstName_ = firstName;
    lastName_ = lastName;
    if (allStudentUnitRecords == null) {
      allStudentUnitRecords_ = new StudentUnitRecordList();
    }
    else {
      allStudentUnitRecords_ = allStudentUnitRecords;
    }
  }

  
  
  //===========================================================================
  // Getters and Setters
  //===========================================================================
  
  public Integer getStudentId() 
  { 
    return studentId_; 
  } 

  
  
  public String getFirstName() 
  { 
    return firstName_; 
  }
  
  
  
  public String getLastName() 
  { 
    return lastName_;
  }

  
  
  public StudentUnitRecordList retrieveAllStudentUnitRecords() 
  { 
    return allStudentUnitRecords_; 
  }

  
  
  public void setFirstName(String firstName) 
  { 
    firstName_ = firstName;
  }

  
  
  public void setLastName(String lastName) 
  { 
    lastName_ = lastName; 
  }
  
  
  
  //===========================================================================
  // Methods: primary
  //===========================================================================
  
  public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord) 
  { 
    allStudentUnitRecords_.add(studentUnitRecord); 
  }

  

  // Return student unit record for unitCode
  public IStudentUnitRecord retrieveStudentUnitRecord(String unitCode) 
  {
    for (IStudentUnitRecord studentUnitRecord : allStudentUnitRecords_) {
      if (studentUnitRecord.getUnitCode().equals(unitCode)) {
        return studentUnitRecord; 
      }
    }
    return null;   
  }
  
  

}
=======
public class Student implements IStudent {
  private Integer studentId; private String studentFirstName;
  private String studentLastName;
  private StudentUnitRecordList su;

  public Student( Integer studentId, String studentFirstName, String studentLastName, StudentUnitRecordList su ) { this.studentId = studentId; this.studentFirstName = studentFirstName;
  this.studentLastName = studentLastName;this.su = 
      su == null ? new StudentUnitRecordList() : 
        su;
  }

  public Integer getID() { return this.studentId; 
  } public String getFirstName() { 
    return studentFirstName; }

  public void setFirstName( String firstName ) { 
    this.studentFirstName = firstName; }

  public String getLastName() { 
    return studentLastName; }
  public void setLastName( String studentLastName ) { 


    this.studentLastName = studentLastName; }

  public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
  public IStudentUnitRecord getUnitRecord( String unitCode ) {
    for ( IStudentUnitRecord r : su ) 
      if ( r.getUnitCode().equals(unitCode)) 
        return r; 

    return null;

  }

  public StudentUnitRecordList getUnitRecords() { return su; }}
>>>>>>> development
