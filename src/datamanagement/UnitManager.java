package datamanagement;

import java.util.List;
import org.jdom.*;

/**
 * Collection of units
 */
public class UnitManager
{
  //===========================================================================
  // Variables
  //===========================================================================

  private static UnitManager instance_ = null;

  private UnitMap unitMap;


  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * restricts access to create new instance, follows Singleton pattern
   */
  private UnitManager() {
    unitMap = new UnitMap();
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * returns Singleton instance
   */
  public static UnitManager getInstance() {
    if (instance_ == null)
      instance_ = new UnitManager();
    return instance_;
  }



  /**
   * returns Unit
   * @param unitCode
   * @return unit with given unitCode
   */
  public IUnit getUnit(String unitCode) {
    IUnit unit = unitMap.get(unitCode);
    if (unit == null) {
      createUnit(unitCode);
    }
    return unit;
  }



  /**
   *
   */
  private IUnit createUnit(String unitCode) {
    IUnit unit;
    List<Element> elements = (List<Element>)XmlManager.getInstance()
        .getDocument().getRootElement().getChild("unitTable").getChildren("unit");
    for (Element element : elements)
      if (unitCode.equals(element.getAttributeValue("uid"))) {
        StudentUnitRecordList studentUnitRecordList  = null;
        unit = new Unit(element.getAttributeValue("uid"),
                        element.getAttributeValue("name"),
                        Float.valueOf(element.getAttributeValue("ps")).floatValue(),
                        Float.valueOf(element.getAttributeValue("cr")).floatValue(),
                        Float.valueOf(element.getAttributeValue("di")).floatValue(),
                        Float.valueOf(element.getAttributeValue("hd")).floatValue(),
                        Float.valueOf(element.getAttributeValue("ae")).floatValue(),
                        Integer.valueOf(element.getAttributeValue("asg1wgt")).intValue(),
                        Integer.valueOf(element.getAttributeValue("asg2wgt")).intValue(),
                        Integer.valueOf(element.getAttributeValue("examwgt")).intValue(),
                        StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));
        unitMap.put(unit.getUnitCode(), unit);
        return unit;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }



  /**
   *
   */
  public UnitMap getUnits() {
    UnitMap unitMap = new UnitMap();
    IUnit unit;
    List<Element> elements = (List<Element>)XmlManager.getInstance()
         .getDocument().getRootElement().getChild("unitTable").getChildren("unit");

    for (Element element : elements) {
      unit = new UnitProxy(element.getAttributeValue("uid"),
                           element.getAttributeValue("name"));
      unitMap.put(unit.getUnitCode(), unit);
    } // unit maps are filled with PROXY units

    return unitMap;
  }



}
