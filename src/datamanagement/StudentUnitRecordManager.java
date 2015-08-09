package datamanagement;

import java.util.List;
import java.util.HashMap;

import org.jdom.Element;

public class StudentUnitRecordManager
{

  // ===========================================================================
  // Variables
  // ===========================================================================

  
  
  private static StudentUnitRecordManager manager_ = null;
  private StudentUnitRecordMap recordMap_;
  private HashMap<String, StudentUnitRecordList> unitRecord_;
  private HashMap<Integer, StudentUnitRecordList> studentRecord_;

  
  
  // ===========================================================================
  // Constructors
  // ===========================================================================

  
  
  private StudentUnitRecordManager()
  {
    recordMap_ = new StudentUnitRecordMap();
    unitRecord_ = new HashMap<>();
    studentRecord_ = new HashMap<>();
  }

  
  
  
  // ===========================================================================
  // Static Methods
  // ===========================================================================

  
  
  public static StudentUnitRecordManager getInstance()
  {
    if (manager_ == null)
      manager_ = new StudentUnitRecordManager();

    return manager_;
  }

  
  
  // ===========================================================================
  // Accessors
  // ===========================================================================

  
  
  public IStudentUnitRecord getStudentUnitRecord(Integer studentID,
      String unitCode)
  {
    IStudentUnitRecord ir = recordMap_.get(studentID.toString() + unitCode);
    return ir != null ? ir : createStudentUnitRecord(studentID, unitCode); // Change to regular if/else?
  }

  public StudentUnitRecordList getRecordsByUnit(String unitCode)
  {
    StudentUnitRecordList recs = unitRecord_.get(unitCode);

    if (recs != null) {
      return recs;
    }

    recs = new StudentUnitRecordList();

    for (Element el : (List<Element>) XMLManager.getInstance().getDocument()
        .getRootElement().getChild("studentUnitRecordTable")
        .getChildren("record")) {
      if (unitCode.equals(el.getAttributeValue("uid"))) {
        recs.add(new StudentUnitRecordProxy(new Integer(el
            .getAttributeValue("sid")), el.getAttributeValue("uid")));
      } // End if
    } // End for

    if (recs.size() > 0) {
      unitRecord_.put(unitCode, recs); // be careful - this could be empty
    }

    return recs;
  }

  public StudentUnitRecordList getRecordsByStudent(Integer studentID)
  {
    StudentUnitRecordList recs = studentRecord_.get(studentID);

    if (recs != null) {
      return recs;
    }

    recs = new StudentUnitRecordList();

    for (Element el : (List<Element>) XMLManager.getInstance().getDocument()
        .getRootElement().getChild("studentUnitRecordTable")
        .getChildren("record")) {
      if (studentID.toString().equals(el.getAttributeValue("sid"))) {
        recs.add(new StudentUnitRecordProxy(new Integer(el
            .getAttributeValue("sid")), el.getAttributeValue("uid")));
      }
    }

    if (recs.size() > 0) {
      studentRecord_.put(studentID, recs); // be careful - this could be empty
    }

    return recs;
  }

  // ===========================================================================
  // Instance Methods
  // ===========================================================================

  private IStudentUnitRecord createStudentUnitRecord(Integer studentId,
      String unitCode)
  {
    IStudentUnitRecord studentUnitRecord;

    List<Element> recordList = (List<Element>) XMLManager.getInstance()
        .getDocument()
        .getRootElement().getChild("studentUnitRecordTable")
        .getChildren("record");

    boolean isStudentIdMatch;
    boolean isUnitCodeMatch;

    for (Element record : recordList) {

      isStudentIdMatch = studentId.toString().equals(
          record.getAttributeValue("sid"));

      isUnitCodeMatch = unitCode.equals(record.getAttributeValue("uid"));

      if (isStudentIdMatch && isUnitCodeMatch) {
        Integer recordStudentId = new Integer(record.getAttributeValue("sid"));
        String recordUnitCode = record.getAttributeValue("uid");

        Float assessmentOneMark = new Float(record.getAttributeValue("asg1"))
            .floatValue();
        Float assessmentTwoMark = new Float(record.getAttributeValue("asg2"))
            .floatValue();
        Float examMark = new Float(record.getAttributeValue("exam"))
            .floatValue();

        studentUnitRecord = new StudentUnitRecord(recordStudentId,
            recordUnitCode, assessmentOneMark, assessmentTwoMark, examMark);

        recordMap_.put(studentUnitRecord.getStudentId().toString()
            + studentUnitRecord.getUnitCode(), studentUnitRecord);

        return studentUnitRecord;
      } // End if
    } // End for

    throw new RuntimeException(
        "DBMD: createStudent : student unit record not in file");
  }
  
  
  
  public void saveRecord(IStudentUnitRecord studentUnitRecord)
  {
    List<Element> recordList = (List<Element>) XMLManager.getInstance()
        .getDocument()
        .getRootElement().getChild("studentUnitRecordTable")
        .getChildren("record");

    boolean isStudentIdMatch;
    boolean isUnitCodeMatch;

    for (Element record : recordList) {

      isStudentIdMatch = studentUnitRecord.getStudentId().toString()
          .equals(record.getAttributeValue("sid"));

      isUnitCodeMatch = studentUnitRecord.getUnitCode().equals(
          record.getAttributeValue("uid"));

      if (isStudentIdMatch && isUnitCodeMatch) {
        record.setAttribute("asg1",
            new Float(studentUnitRecord.getAssessmentOneMark()).toString());
        record.setAttribute("asg2",
            new Float(studentUnitRecord.getAssessmentTwoMark()).toString());
        record.setAttribute("exam",
            new Float(studentUnitRecord.getExamMark()).toString());

        XMLManager.getInstance().saveDocument(); // write out the XML file for                  
                                                 // continuous save
        return;                             
      } // End if
    } // End for

    throw new RuntimeException(
        "DBMD: saveRecord : no such student record in data");
  }
}
