package datamanagement;

import java.util.List;

import org.jdom.Element;

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

  private static UnitManager instance_ = null;

  private UnitMap unitMap_;

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
    unitMap_ = new UnitMap();
  }



  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   * Returns the sole xmlManager instance (following the singleton pattern).
   * @return XMLManager Returns sole XMLManager instance responsible for
   * managing data from xml file.
   */
  public static UnitManager getInstance()
  {
    if (instance_ == null) {
      instance_ = new UnitManager();
    }
    return instance_;
  }



  /**
   * Returns a unit (either from collection of units in memory, or from xml
   * file - if it exists).
   * @param unitCode Unit code.
   * @return IUnit Returns a unit.
   */
  public IUnit getUnit(String unitCode)
  {
    IUnit unit = this.unitMap_.get(unitCode);
    return unit != null ? unit : createUnit(unitCode);
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
    IUnit unit;

    for (Element element : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("unitTable").getChildren("unit"))
      if (unitCode.equals(element.getAttributeValue("uid"))) {


        unit = new Unit(element.getAttributeValue("uid"),
                        element.getAttributeValue("name"),
                        Float.valueOf(element.getAttributeValue("ps"))
                             .floatValue(),
                        Float.valueOf( element.getAttributeValue( "cr" ) )
                             .floatValue(),
                        Float.valueOf(element.getAttributeValue("di"))
                             .floatValue(),
                        Float.valueOf( element.getAttributeValue( "hd" ) )
                             .floatValue(),
                        Float.valueOf(element.getAttributeValue("ae"))
                             .floatValue(),
                        Integer.valueOf(element.getAttributeValue("asg1wgt"))
                               .intValue(),
                        Integer.valueOf(element.getAttributeValue("asg2wgt"))
                               .intValue(),
                        Integer.valueOf(element.getAttributeValue("examwgt"))
                               .intValue(),
                        StudentUnitRecordManager.instance()
                               .getRecordsByUnit( unitCode ));

        unitMap_.put(unit.getUnitCode(), unit);

        return unit;
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
    UnitMap unitMap;
    IUnit unit;
    unitMap = new UnitMap();

    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
        .getRootElement().getChild("unitTable").getChildren("unit")) {
      unit = new UnitProxy(el.getAttributeValue("uid"),
                         el.getAttributeValue("name"));
      unitMap.put(unit.getUnitCode(), unit);
    } // unit maps are filled with PROXY units
    return unitMap;
  }



}
