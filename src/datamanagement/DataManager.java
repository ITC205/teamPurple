package datamanagement;

import java.util.List;

import java.io.IOException;
import java.io.FileWriter;

import org.jdom.JDOMException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Responsible for loading data from XML file, holding the transformed set
 * of data used by the application and saving data back to XML file.
 */
public class DataManager
{
  //============================================================================
  // Variables
  //============================================================================



  private static DataManager instance_ = null;
  
  private Document document_;



  //============================================================================
  // Constructors
  //============================================================================



  /**
   * Creates and initializes a new DataManager instance following the singleton
   * pattern. Creation of new instances is restricted through private access
   * modifier.
   */
  private DataManager()
  {
    initialize();
  }



  //============================================================================
  // Getters & setters
  //============================================================================



  /**
   * Returns the sole DataManager instance (following the singleton pattern).
   * @return DataManager instance responsible for managing data from XML file.
   */
  public static DataManager getInstance()
  {
    if (instance_ == null) {
      instance_ = new DataManager();
    }
    return instance_;
  }



  /**
   * Returns the object which holds the transformed set of data loaded from
   * the XML file.
   * @return Document Holds the transformed set of data constructed by
   * SAXBuilder expanding entities from the XML file.
   */
  public Document getDocument()
  {
    return document_;
  }



  /**
   * Sets the object which holds the transformed set of data loaded from
   * the XML file. Private access restricts use to the DataManger instance
   * itself.
   * @param document Document Holds the transformed set of data constructed by
   * SAXBuilder expanding entities from the XML file.
   */
  private void setDocument(Document document)
  {
    document_ = document;
  }



  //============================================================================
  // Methods
  //============================================================================



  /**
   * Initializes singleton instance of DataManager, attempts to load data from
   * XML file, logging and throwing any exceptions this causes.
   */
  public void initialize()
  {
    String xmlFileName = ApplicationProperties.getInstance().xmlFileName();
    try {
      buildFromXmlAndLoadDocument(xmlFileName);
    }
    catch (JDOMException exception) {
      logAndThrowException("initialize: JDOMException");
    }
    catch (IOException exception) {
      logAndThrowException("initialize: IOException");
    }
  }



  private void buildFromXmlAndLoadDocument(String xmlFileName)
    throws JDOMException, IOException
  {
    SAXBuilder saxBuilder = new SAXBuilder();
    saxBuilder.setExpandEntities(true);
    Document document = saxBuilder.build(xmlFileName);
    setDocument( document );
  }



  private void logAndThrowException(String callingMethodAndExceptionMessage)
  {
    String errorMessage = "XMLManager : " + callingMethodAndExceptionMessage;

    System.err.printf("%s", errorMessage + "\n");
    throw new RuntimeException(errorMessage);
  }



  /**
   * Attempts to save data back to XML file, logging and throwing any
   * exceptions this causes.
   */
  public void saveDocument()
  {
    String xmlFileName = ApplicationProperties.getInstance().xmlFileName();

    try (FileWriter fileWriter = new FileWriter(xmlFileName)) {
      convertDocumentToXmlAndSaveFile(fileWriter);
    }
    catch (IOException exception) {
      logAndThrowException("saveDocument : error writing to file");
    }
  }



  private void convertDocumentToXmlAndSaveFile(FileWriter fileWriter)
    throws IOException
  {
    XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
    xmlOutputter.output(getDocument(), fileWriter);
    fileWriter.close();
  }



  /**
   * Transforms (and returns) the collection of Units that are stored in the
   * XML file into a List of JDOM Elements.
   * @return List<Element> List of JDOM Elements which represent the collection
   * of Units from the XML file.
   */
  public List<Element> retrieveAllUnitElements()
  {
    List<Element> allUnitElements = getDocument().getRootElement()
                                    .getChild("unitTable")
                                    .getChildren("unit");
    return allUnitElements;
  }



  /**
   * Transforms (and returns) the collection of Student Unit Records that are
   * stored in the XML file into a List of JDOM Elements.
   * @return List<Element> List of JDOM Elements which represent the collection
   * of Student Unit Records from the XML file.
   */
  public List<Element> retrieveAllStudentUnitRecordElements()
  {
    List<Element> allUnitElements = getDocument().getRootElement()
                                    .getChild("studentUnitRecordTable")
                                    .getChildren("record");
    return allUnitElements;
  }



  /**
   * Transforms (and returns) the collection of Students that are stored in the
   * XML file into a List of JDOM Elements.
   * @return List<Element> List of JDOM Elements which represent the collection
   * of Students from the XML file.
   */
  public List<Element> retrieveAllStudentElements()
  {
    List<Element> allUnitElements = getDocument().getRootElement()
                                    .getChild("studentTable")
                                    .getChildren("student");
    return allUnitElements;
  }

}
