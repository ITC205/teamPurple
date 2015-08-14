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
 * Responsible for loading data from xml file, holding the transformed set
 * of data used by the application and saving data back to xml file.
 */
public class XmlManager
{
  //===========================================================================
  // Variables
  //===========================================================================

  private static XmlManager instance_ = null;
  
  private Document document_;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates and initializes a new XMLManager instance following the singleton
   * pattern.
   * Creation of new instances is restricted through private access modifier.
   */
  private XmlManager()
  {
    initialize();
  }



  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * Returns the sole xmlManager instance (following the singleton pattern).
   * @return XMLManager instance responsible for managing data from xml file.
   */
  public static XmlManager getInstance()
  {
    if (instance_ == null) {
      instance_ = new XmlManager();
    }
    return instance_;
  }



  /**
   * Returns the object which holds the transformed set of data loaded from
   * the xml file.
   * @return Document Holds the transformed set of data constructed by
   * SAXBuilder expanding entities from the xml file.
   */
  public Document getDocument()
  {
    return this.document_;
  }



  /**
   * Sets the object which holds the transformed set of data loaded from
   * the xml file.
   * Private access restricts use to the XMLManger instance itslef.
   * @param document Document Holds the transformed set of data constructed by
   * SAXBuilder expanding entities from the xml file.
   */
  private void setDocument(Document document)
  {
    this.document_ = document;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Initializes singleton instance xmlManager and loads data from xml file.
   */
  public void initialize()
  {
    // TODO: prefer a AppProperties.getInstance().getXmlFileName();
    String xmlFileName = AppProperties.getInstance().getProperties()
                                      .getProperty("XMLFILE");
    try {
      buildAndLoadDocument(xmlFileName);
    }
    catch (JDOMException exception) {
      logAndThrowException("JDOMException");
    }
    catch (IOException exception) {
      logAndThrowException("IOException");
    }
  }



  /**
   *
   */
  private void buildAndLoadDocument(String xmlFileName)
    throws JDOMException, IOException
  {
    SAXBuilder saxBuilder = new SAXBuilder();
    saxBuilder.setExpandEntities(true);
    Document document = saxBuilder.build(xmlFileName);
    this.setDocument(document);
  }



  /**
   *
   */
  private void logAndThrowException(String exceptionType)
  {
    String errorMessageStart = "DBMD: XMLManager : initialize : ";
    System.err.printf("%s", errorMessageStart + exceptionType + "\n");
    throw new RuntimeException(errorMessageStart + exceptionType);
  }



  /**
   * Saves data back to xml file.
   */
  public void saveDocument()
  {
    // TODO: see initialize;
    String xmlFileName = AppProperties.getInstance()
                                  .getProperties().getProperty( "XMLFILE" );

    try (FileWriter fileWriter = new FileWriter(xmlFileName)) {
      XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
      xmlOutputter.output(this.getDocument(), fileWriter);
      fileWriter.close();
    }
    catch (IOException exception) {
      // TODO: message, refactor logging and throw
      System.err.printf("%s\n", "DBMD : XMLManager : saveDocument : Error " +
                        "saving XML to " + xmlFileName);
      throw new RuntimeException("DBMD: XMLManager : saveDocument : error " +
                                 "writing to file");
    }
  }



  /**
   *
   */
  public List<Element> retrieveAllUnitElements()
  {
    List<Element> allUnitElements = this.getDocument()
                                        .getRootElement()
                                        .getChild("unitTable")
                                        .getChildren("unit");
    return allUnitElements;
  }



  /**
   *
   */
  public List<Element> retrieveAllStudentUnitRecordElements()
  {
    List<Element> allUnitElements = this.getDocument()
                                        .getRootElement()
                                        .getChild("studentUnitRecordTable")
                                        .getChildren("record");
    return allUnitElements;
  }



  /**
   *
   */
  public List<Element> retrieveAllStudentElements()
  {
    List<Element> allUnitElements = this.getDocument()
                                        .getRootElement()
                                        .getChild("studentTable")
                                        .getChildren("student");
    return allUnitElements;
  }



}
