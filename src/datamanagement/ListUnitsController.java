package datamanagement;

/**
 *
 */
public class ListUnitsController
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
  public ListUnitsController()
  {
    unitManager_ = UnitManager.getInstance();
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
    UnitMap units = this.unitManager_.retrieveAllUnits();
    for (String unitCode : units.keySet()) {
      unitLister.addUnit(units.get(unitCode));
    }
  }



}
