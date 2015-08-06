package datamanagement;

import java.io.IOException;
import java.io.FileWriter;

import org.jdom.JDOMException;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Responsible for loading data from xml file, holding the transformed set
 * of data used by the application and saving data back to xml file.
 */
public class XMLManager
{
  //===========================================================================
  // Variables
  //===========================================================================

  private static XMLManager self_ = null;
  
  private Document document_;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates and initializes a new XMLManager instance following the singleton
   * pattern.
   * Creation of new instances is restricted through private access modifier.
   */
  private XMLManager()
  {
    init();
  }



  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * Returns the sole xmlManager instance (following the singleton pattern).
   * @return XMLManager instance responsible for managing data from xml file.
   */
  public static XMLManager getXML()
  {
    if (self_ == null) self_ = new XMLManager(); return self_;
  }



  /**
   * Returns the object which holds the transformed set of data loaded from
   * the xml file.
   * @return Document Holds the transformed set of data constructed by
   * SAXBuilder expanding entities from the xml file.
   */
  public Document getDocument()
  {
    return document_;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Initializes singleton instance xmlManager and loads data from xml file.
   */
  public void init()
  {
    String xmlFileName = AppProperties.getInstance()
                            .getProperties().getProperty("XMLFILE");

    try {
      SAXBuilder saxBuilder = new SAXBuilder();
      saxBuilder.setExpandEntities(true);
      document_ = saxBuilder.build(xmlFileName);
    }
    // TODO: name exception more specifically?
    catch (JDOMException exception) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught JDOMException\n");
      throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
    }
    // TODO: name exception more specifically?
    catch (IOException exception) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught IOException\n");
      throw new RuntimeException("DBMD: XMLManager : init : IOException");
    }
  }



  /**
   * Saves data back to xml file.
   */
  public void saveDocument()
  {
    String xmlFileName = AppProperties.getInstance()
                                  .getProperties().getProperty("XMLFILE");
    try (FileWriter fileWriter = new FileWriter(xmlFileName)) {
      XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
      xmlOutputter.output( document_, fileWriter );
      fileWriter.close();
    }
    catch (IOException exception) {
      System.err.printf( "%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlFileName);
      throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
    }
  }



}
