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

  private static XMLManager self = null;

  private Document doc;

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
    if (self == null) self = new XMLManager(); return self;
  }



  /**
   * Returns the object which holds the transformed set of data loaded from
   * the xml file.
   * @return Document Holds the transformed set of data constructed by
   * SAXBuilder expanding entities from the xml file.
   */
  public Document getDocument()
  {
    return doc;
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Initializes singleton instance xmlManager and loads data from xml file.
   */
  public void init()
  {
    String s = AppProperties.getInstance()
                            .getProperties().getProperty("XMLFILE");

    try {
      SAXBuilder b = new SAXBuilder();
      b.setExpandEntities(true);
      doc = b.build(s);
    }
    catch (JDOMException e) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught JDOMException\n");
      throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
    }
    catch (IOException e) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught IOException\n");
      throw new RuntimeException("DBMD: XMLManager : init : IOException");
    }
  }



  /**
   * Saves data back to xml file.
   */
  public void saveDocument()
  {
    String xmlfile = AppProperties.getInstance()
                                  .getProperties().getProperty("XMLFILE");
    try (FileWriter fout = new FileWriter(xmlfile)) {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(doc, fout);
      fout.close();
    }
    catch (IOException ioe) {
      System.err.printf( "%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlfile);
      throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
    }
  }



}
