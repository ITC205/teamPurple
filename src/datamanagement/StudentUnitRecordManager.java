package datamanagement;

import java.util.List;
import java.util.HashMap;

import org.jdom.Element;

public class StudentUnitRecordManager
{

	//===========================================================================
  // Variables
  //===========================================================================
	
	
	
	private static StudentUnitRecordManager manager_ = null;
	private StudentUnitRecordMap recordMap_;
	private HashMap<String, StudentUnitRecordList> ur; // What is this?
	private HashMap<Integer, StudentUnitRecordList> sr; // And this?

	
	
	//===========================================================================
  // Constructors
  //===========================================================================
	
	
	
	private StudentUnitRecordManager()
	{
		recordMap_ = new StudentUnitRecordMap();
		ur = new HashMap<>();
		sr = new HashMap<>();
	}
	
	
	
	//===========================================================================
  // Static Methods
  //===========================================================================
	
	
	
	public static StudentUnitRecordManager getInstance() // Change to getInstance() Affects multiple classes
	{
		if (manager_ == null)
			manager_ = new StudentUnitRecordManager();
		
		return manager_;
	}
	
	
	
	//===========================================================================
  // Accessors
  //===========================================================================

	
	
	public IStudentUnitRecord getStudentUnitRecord(Integer studentID,
			String unitCode)
	{
		IStudentUnitRecord ir = recordMap_.get(studentID.toString() + unitCode);
		return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);
	}

	
	
	public StudentUnitRecordList getRecordsByUnit(String unitCode)
	{
		StudentUnitRecordList recs = ur.get(unitCode);
		if (recs != null)
			return recs;
		recs = new StudentUnitRecordList();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("studentUnitRecordTable")
				.getChildren("record")) {
			if (unitCode.equals(el.getAttributeValue("uid")))
				recs.add(new StudentUnitRecordProxy(new Integer(el
						.getAttributeValue("sid")), el.getAttributeValue("uid")));
		}
		if (recs.size() > 0)
			ur.put(unitCode, recs); // be careful - this could be empty
		return recs;
	}

	
	
	public StudentUnitRecordList getRecordsByStudent(Integer studentID)
	{
		StudentUnitRecordList recs = sr.get(studentID);
		if (recs != null)
			return recs;
		recs = new StudentUnitRecordList();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("studentUnitRecordTable")
				.getChildren("record"))
			if (studentID.toString().equals(el.getAttributeValue("sid")))
				recs.add(new StudentUnitRecordProxy(new Integer(el
						.getAttributeValue("sid")), el.getAttributeValue("uid")));
		if (recs.size() > 0)
			sr.put(studentID, recs); // be careful - this could be empty
		return recs;
	}

	
	
	//===========================================================================
  // Instance Methods
  //===========================================================================
	
	
	
	private IStudentUnitRecord createStudentUnitRecord(Integer uid, String sid)
	{
		IStudentUnitRecord ir;
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("studentUnitRecordTable")
				.getChildren("record")) {
			if (uid.toString().equals(el.getAttributeValue("sid"))
					&& sid.equals(el.getAttributeValue("uid"))) {
				ir = new StudentUnitRecord(new Integer(el.getAttributeValue("sid")),
						el.getAttributeValue("uid"),
						new Float(el.getAttributeValue("asg1")).floatValue(), new Float(
								el.getAttributeValue("asg2")).floatValue(), new Float(
								el.getAttributeValue("exam")).floatValue());
				recordMap_.put(ir.getStudentID().toString() + ir.getUnitCode(), ir);
				return ir;
			} // End if
		} // End for
		throw new RuntimeException(
				"DBMD: createStudent : student unit record not in file");
	}
	
	
	
	public void saveRecord(IStudentUnitRecord irec)
	{
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("studentUnitRecordTable")
				.getChildren("record")) {
			if (irec.getStudentID().toString().equals(el.getAttributeValue("sid"))
					&& irec.getUnitCode().equals(el.getAttributeValue("uid"))) {
				el.setAttribute("asg1", new Float(irec.getAssessmentOneMark()).toString());

				el.setAttribute("asg2", new Float(irec.getAssessmentTwoMark()).toString());
				el.setAttribute("exam", new Float(irec.getExamMark()).toString());
				XMLManager.getXML().saveDocument(); // write out the XML file for
																						// continuous save
				return;
			}
		}

		throw new RuntimeException(
				"DBMD: saveRecord : no such student record in data");
	}
}
