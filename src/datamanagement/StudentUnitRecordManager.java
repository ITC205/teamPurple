package datamanagement;

import java.util.List;
import java.util.HashMap;

import org.jdom.Element;

public class StudentUnitRecordManager
{
  // ===========================================================================
  // Variables
  // ===========================================================================



  private static StudentUnitRecordManager instance_ = null;
  private StudentUnitRecordMap studentUnitRecordMap_;
  private HashMap<String, StudentUnitRecordList> unitRecord_;
  private HashMap<Integer, StudentUnitRecordList> studentRecord_;



  // ===========================================================================
  // Constructors
  // ===========================================================================



  private StudentUnitRecordManager()
  {
    studentUnitRecordMap_ = new StudentUnitRecordMap();
    unitRecord_ = new HashMap<>();
    studentRecord_ = new HashMap<>();
  }


 
  // ===========================================================================
  // Methods
  // ===========================================================================



  public static StudentUnitRecordManager getInstance()
  {
    if (instance_ == null) {
      instance_ = new StudentUnitRecordManager();
    }
    return instance_;
  }



  public IStudentUnitRecord findStudentUnitRecord(Integer studentId,
          String unitCode)
  {
    IStudentUnitRecord studentUnitRecord = studentUnitRecordMap_
                                           .get(studentId.toString() + 
                                           unitCode);

    if (studentUnitRecord != null) {
      return studentUnitRecord;
    }
    else {
      studentUnitRecord = loadStudentUnitRecord(studentId, unitCode);
      return studentUnitRecord;
    }
  }
  
  
  
  public StudentUnitRecordList findStudentRecordsByUnit(String unitCode)
  {
    StudentUnitRecordList studentRecordsByUnit = unitRecord_.get(unitCode);

    if (studentRecordsByUnit != null) {
      return studentRecordsByUnit;
    }
    else {
      studentRecordsByUnit = new StudentUnitRecordList();
      List<Element> allStudentUnitRecordElements = (List<Element>) XMLManager
                                             .getInstance()
                                             .getDocument().getRootElement()
                                             .getChild("studentUnitRecordTable")
                                             .getChildren("record");

      for (Element studentUnitRecordElement : allStudentUnitRecordElements) {
        if (unitCode.equals(studentUnitRecordElement
                            .getAttributeValue("uid"))) {
          studentRecordsByUnit.add(new StudentUnitRecordProxy(
                  new Integer(studentUnitRecordElement
                              .getAttributeValue("sid")),
                  studentUnitRecordElement.getAttributeValue("uid")));
        } // End if
      } // End for

      boolean isThereRecordsToAdd = studentRecordsByUnit.size() > 0;
      
      if (isThereRecordsToAdd) {
        unitRecord_.put(unitCode, studentRecordsByUnit);
      }
      
      return studentRecordsByUnit;
    } // End else
  }



  public StudentUnitRecordList findUnitRecordsByStudent(Integer studentId)
  {
    StudentUnitRecordList unitRecordsByStudent = studentRecord_.get(studentId);

    if (unitRecordsByStudent != null) {
      return unitRecordsByStudent;
    }
    else {
      unitRecordsByStudent = new StudentUnitRecordList();
      List<Element> allStudentUnitRecordElements = (List<Element>) XMLManager
                                              .getInstance()
                                             .getDocument().getRootElement()
                                             .getChild("studentUnitRecordTable")
                                             .getChildren("record");

      for (Element studentUnitRecordElement : allStudentUnitRecordElements) {
        boolean isStudentIdMatch = studentId.toString()
                                   .equals(studentUnitRecordElement
                                   .getAttributeValue("sid"));

        if (isStudentIdMatch) {
          unitRecordsByStudent.add(new StudentUnitRecordProxy(
                  new Integer(studentUnitRecordElement
                              .getAttributeValue("sid")),
                  studentUnitRecordElement.getAttributeValue("uid")));
        } // End if
      } // End for
      
      boolean isThereRecordsToAdd = unitRecordsByStudent.size() > 0;
      
      if (isThereRecordsToAdd) {
      studentRecord_.put(studentId, unitRecordsByStudent);
      }

      return unitRecordsByStudent;
    } // End else
  }
  
  
  
  private IStudentUnitRecord loadStudentUnitRecord(Integer studentId,
          String unitCode)
  {
    IStudentUnitRecord studentUnitRecord;

    List<Element> allStudentUnitRecordElements = (List<Element>) XMLManager
                                             .getInstance()
                                             .getDocument().getRootElement()
                                             .getChild("studentUnitRecordTable")
                                             .getChildren("record");

    boolean isStudentIdMatch;
    boolean isUnitCodeMatch;

    for (Element studentUnitRecordElement : allStudentUnitRecordElements) {
      isStudentIdMatch = studentId.toString()
                                  .equals(studentUnitRecordElement
                                  .getAttributeValue("sid"));

      isUnitCodeMatch = unitCode.equals(studentUnitRecordElement
                                .getAttributeValue("uid"));

      if (isStudentIdMatch && isUnitCodeMatch) {

        Float markForAssignmentOne = new Float(studentUnitRecordElement
                                               .getAttributeValue("asg1"))
                                               .floatValue();
        Float markForAssignmentTwo = new Float(studentUnitRecordElement
                                               .getAttributeValue("asg2"))
                                               .floatValue();
        Float markForExam = new Float(studentUnitRecordElement
                                      .getAttributeValue("exam"))
                                      .floatValue();

        studentUnitRecord = new StudentUnitRecord(studentId,
                                                  unitCode, 
                                                  markForAssignmentOne, 
                                                  markForAssignmentTwo, 
                                                  markForExam);

        studentUnitRecordMap_.put(studentUnitRecord.getStudentId().toString()
                     + studentUnitRecord.getUnitCode(), 
                       studentUnitRecord);

        return studentUnitRecord;
      }    // End if
    }    // End for

    throw new RuntimeException(
            "StudentUnitRecordManager: createStudentUnitRecord : "
            + "student unit record not in file");
  }



  public void saveStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
  {
    List<Element> allStudentUnitRecordElements = (List<Element>) XMLManager
                                             .getInstance()
                                             .getDocument().getRootElement()
                                             .getChild("studentUnitRecordTable")
                                             .getChildren("record");

    boolean isStudentIdMatch;
    boolean isUnitCodeMatch;

    for (Element studentUnitRecordElement : allStudentUnitRecordElements) {
      isStudentIdMatch = studentUnitRecord.getStudentId().toString()
                                          .equals(studentUnitRecordElement
                                          .getAttributeValue("sid"));

      isUnitCodeMatch = studentUnitRecord.getUnitCode()
                                         .equals(studentUnitRecordElement
                                         .getAttributeValue("uid"));

      if (isStudentIdMatch && isUnitCodeMatch) {
        studentUnitRecordElement.setAttribute("asg1",
                new Float(studentUnitRecord.getMarkForAssignmentOne())
                                           .toString());
        studentUnitRecordElement.setAttribute("asg2",
                new Float(studentUnitRecord.getMarkForAssignmentTwo())
                                           .toString());
        studentUnitRecordElement.setAttribute("exam",
                new Float(studentUnitRecord.getMarkForExam()).toString());

        XMLManager.getInstance().saveDocument(); // write out the XML file for
                                                 // continuous save
        return;
      }   // End if
    }   // End for

    throw new RuntimeException(
            "StudentUnitRecordManager: saveRecord : "
            + "no such student record in data");
  }
}
