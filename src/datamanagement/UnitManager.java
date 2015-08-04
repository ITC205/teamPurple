package datamanagement;

import java.util.List;

import org.jdom.*;

/**
 * Creates and manages the collection of units.
 * Allows units to be created and added to the collection
 * and retrieves a specified unit or entire collection.
 */
public class UnitManager
{
  //===========================================================================
  // Variables
  //===========================================================================

  private static UnitManager self = null;

  private UnitMap UM;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates and initializes a new UnitManager instance following the
   * singleton pattern.
   * Creation of new instances is restricted through private access modifier.
   */
  private UnitManager()
  {
    UM = new UnitMap();
  }



  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * Returns the sole xmlManager instance (following the singleton pattern).
   * @return XMLManager Returns sole XMLManager instance responsible for
   * managing data from xml file.
   */
  public static UnitManager UM()
  {
    if (self == null) {
      self = new UnitManager();
    }
    return self;
  }



  /**
   * Returns a unit (either from collection of units in memory, or from xml
   * file - if it exists).
   * @param uc Unit code.
   * @return IUnit Returns a unit.
   */
  public IUnit getUnit(String uc)
  {
    IUnit iu = this.UM.get(uc);
    return iu != null ? iu : createUnit(uc);
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Creates a unit from xml file representation.
   * @param unitCode Unit code used to match uid of unit in xml file
   * @return IUnit Returns unit.
   */
  private IUnit createUnit(String unitCode)
  {
    IUnit iu;

    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("unitTable").getChildren("unit"))
      if (unitCode.equals(el.getAttributeValue("uid"))) {
        StudentUnitRecordList slist;

        slist = null;

        iu = new Unit(el.getAttributeValue("uid"),
        el.getAttributeValue("name"), Float.valueOf(
        el.getAttributeValue("ps")).floatValue(), Float
        .valueOf( el.getAttributeValue("cr"))
        .floatValue(), Float.valueOf(
        el.getAttributeValue("di")).floatValue(), Float
        .valueOf( el.getAttributeValue("hd"))
        .floatValue(), Float.valueOf(
        el.getAttributeValue("ae")).floatValue(),
        Integer.valueOf(el.getAttributeValue("asg1wgt"))
        .intValue(), Integer.valueOf(
        el.getAttributeValue("asg2wgt")).intValue(),
        Integer.valueOf(el.getAttributeValue("examwgt"))
        .intValue(), StudentUnitRecordManager
        .instance().getRecordsByUnit(unitCode));

        UM.put(iu.getUnitCode(), iu);

        return iu;
      }

      throw new RuntimeException("DBMD: createUnit : unit not in file");
  }



  /**
   * Returns the collection of units that are represented in the xml file.
   * @return UnitMap Returns the collection of units that are represented in
   * the xml file.
   */
  public UnitMap getUnits()
  {
    UnitMap uM;
    IUnit iu;
    uM = new UnitMap();

    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("unitTable").getChildren("unit")) {
      iu = new UnitProxy(el.getAttributeValue("uid"),
      el.getAttributeValue("name"));
      uM.put(iu.getUnitCode(), iu);
    } // unit maps are filled with PROXY units
    return uM;
  }



}
