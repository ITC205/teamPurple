package datamanagement;

/**
 *
 */
public class ListUnitsCTL
{
  //===========================================================================
  // Variables
  //===========================================================================

  private UnitManager unitManager_;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates new instance and references singleton UnitManager instance
   * in order to access the collection of units.
   */
  public ListUnitsCTL() {
    unitManager_ = UnitManager.UM();
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   *
   */
  public void listUnits(IUnitLister unitLister)
  {
    unitLister.clearUnits();
    UnitMap units = unitManager_.getUnits();
    for (String unitCode : units.keySet()) {
      unitLister.addUnit(units.get(unitCode));
    }
  }



}
