package datamanagement;

import java.util.List;

import org.jdom.Element;

/**
 * Data Access Object: manages retrieval of units in persistence layer.
 * Loads the entire collection of units and retrieves, creates and adds a
 * specified unit to the collection.
 */
public class UnitManager
{
  //============================================================================
  // Variables
  //============================================================================



  private static UnitManager instance_ = null;

  private UnitMap allUnits_;



  //============================================================================
  // Constructors
  //============================================================================



  /**
   * Creates and initializes a new UnitManager instance following the
   * singleton pattern.
   * Creation of new instances is restricted through private access modifier.
   */
  private UnitManager()
  {
    allUnits_ = new UnitMap();
  }



  //============================================================================
  // Getters & setters
  //============================================================================



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
   * Returns a unit from the collection of units, and if not not in the
   * collection it checks if the unit exists in the xml file (and if so,
   * instantiates it and adds it to the collection)
   * @param unitCode Unit code.
   * @return IUnit Returns a unit.
   */
  public IUnit getUnit(String unitCode)
  {
    IUnit unit = this.getUnits().get(unitCode);
    if (unit == null) {
      unit = loadUnit(unitCode);
    }
    return unit;
  }



  /**
   * Returns the collection of all units held by this unitManager singleton.
   * Private access restricts use to this instance only.
   * @return UnitMap Returns a UnitMap.
   */
  private UnitMap getUnits()
  {
    return this.allUnits_;
  }



  /**
   * Adds a unit to collection of all units held by this unitManager singleton.
   * Private access restricts use to this instance only.
   * @param unitMap unitMap replaces the current collection of units.
   */
  private void setUnits(UnitMap unitMap)
  {
    this.allUnits_ = unitMap;
  }



  //============================================================================
  // Methods
  //============================================================================

  /**
   * Returns (after instantiation of the objects) the collection of units that
   * are stored in the persistence layer.
   * The collection of units managed by this DAO instance is NOT updated.
   * @return UnitMap Returns the collection of units that are represented in
   * the persistence layer.
   */
  public UnitMap retrieveAllUnits()
  {
    List<Element> unitElements = retrieveAllUnitElements();
    UnitMap unitMap = createAllRetrievedUnitProxies(unitElements);
    return unitMap;
  }



  /**
   * Returns the xml Elements that represent the persisted unit objects.
   * @return List<Element> Returns the list of Elements that represent units.
   */
  private List<Element> retrieveAllUnitElements()
  {
    return XmlManager.getInstance().retrieveAllUnitElements();
  }



  /**
   * Creates a collection of all the unit proxies from the representation in
   * the persistence layer.
   * @param allUnitElements List<Element> List of Elements that represents
   *                        the units in the persistence layer.
   * @return UnitMap Returns UnitMap containing all the instantiated Unit
   *         Proxy objects.
   */
  private UnitMap createAllRetrievedUnitProxies( List<Element> allUnitElements )
  {
    UnitMap unitMap = new UnitMap();
    IUnit unit;

    for (Element unitElement : allUnitElements) {
      unit = new UnitProxy(unitElement.getAttributeValue("uid"),
                           unitElement.getAttributeValue("name"));
      unitMap.put(unit.getUnitCode(), unit);
    }
    return unitMap;
  }



  /**
   * If the specified unit exists in the persistence layer, a unit object is
   * created and added to the collection of units managed by this DAO instance.
   * @param unitCode Unit code used to match unit in persistence layer.
   * @return IUnit Returns unit.
   */
  private IUnit loadUnit(String unitCode) {

    Element unitElement = retrieveUnitElement( unitCode );

    if (unitElement == null) {
      throw new RuntimeException("UnitManager: loadUnit : unit not in file");
    }
    else {
      IUnit unit = createRetrievedUnit(unitElement, unitCode);
      addUnitToCollection(unit);
      return unit;
    }
  }



  /**
   * Returns the xml Element that represents the persisted unit object.
   * @param unitCode String Unit code.
   * @return Element Returns the Element that represents the specified unit.
   */
  private Element retrieveUnitElement(String unitCode)
  {
    List<Element> unitElements = this.retrieveAllUnitElements();
    for (Element element : unitElements) {
      if (unitCode.equals(element.getAttributeValue("uid"))) {
        return element;
      }
    }
    return null;
  }



  /**
   * Creates a unit object from the representation in the persistence layer.
   * @param unitElement Element XML Element that represents the unit.
   * @param unitCode Unit code used to match unit in persistence layer.
   * @return IUnit Returns unit.
   */
  private IUnit createRetrievedUnit( Element unitElement, String unitCode )
  {
    return new Unit(unitElement.getAttributeValue("uid"),
                    unitElement.getAttributeValue("name"),
                    Float.valueOf(unitElement.getAttributeValue("ps"))
                         .floatValue(),
                    Float.valueOf(unitElement.getAttributeValue("cr"))
                         .floatValue(),
                    Float.valueOf(unitElement.getAttributeValue("di"))
                         .floatValue(),
                    Float.valueOf(unitElement.getAttributeValue("hd"))
                         .floatValue(),
                    Float.valueOf(unitElement.getAttributeValue("ae"))
                         .floatValue(),
                    Integer.valueOf(unitElement.getAttributeValue("asg1wgt"))
                           .intValue(),
                    Integer.valueOf(unitElement.getAttributeValue("asg2wgt"))
                           .intValue(),
                    Integer.valueOf(unitElement.getAttributeValue("examwgt"))
                           .intValue(),
                    StudentUnitRecordManager.getInstance()
                           .findStudentRecordsByUnit(unitCode));
  }



  /**
   * Adds the specified unit to the collection of units managed by this DAO
   * instance.
   * @param unit Unit The unit to add to the collection managed by this DAO
   * instance.
   */
  private void addUnitToCollection(IUnit unit)
  {
    UnitMap unitMap = this.getUnits();
    unitMap.put(unit.getUnitCode(), unit);
    this.setUnits(unitMap);
  }

}
