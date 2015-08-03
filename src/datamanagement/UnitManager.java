package datamanagement;

import java.util.List;

import org.jdom.*;

/**
 * collection of units, implemented as a Singleton
 * allows units to be created and added to the collection
 * and retrieves a specified unit or entire collection
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
   *
   */
  private UnitManager()
  {
    UM = new UnitMap();
  }



  //===========================================================================
  // Getters & setters
  //===========================================================================

  /**
   *
   */
  public IUnit getUnit(String uc)
  {
    IUnit iu = UM.get(uc);
    return iu != null ? iu : createUnit(uc);
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   *
   */
  public static UnitManager UM()
  {
    if (self == null) {
      self = new UnitManager();
    }
    return self;
  }



  /**
   *
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
        .valueOf( el.getAttributeValue( "cr" ) )
        .floatValue(), Float.valueOf(
        el.getAttributeValue("di")).floatValue(), Float
        .valueOf( el.getAttributeValue( "hd" ) )
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
   *
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
