package datamanagement;

/**
 *
 */
public class ListUnitsController
{
  //============================================================================
  // Variables
  //============================================================================



  private UnitManager unitManager_;



  //============================================================================
  // Constructors
  //============================================================================



  /**
   * Creates new instance and references singleton UnitManager instance
   * in order to access the collection of units.
   */
  public ListUnitsController()
  {
    unitManager_ = UnitManager.getInstance();
  }



  //============================================================================
  // Getters and Setters
  //============================================================================



  /**
   *
   */
  private UnitManager getUnitManager()
  {
    return this.unitManager_;
  }



  //============================================================================
  // Methods
  //============================================================================



  /**
   *
   */
  public void listAllUnits(IUnitLister unitLister)
  {
    unitLister.clearUnitsFromComboBox();
    UnitMap allUnits = this.getUnitManager().retrieveAllUnits();
    for (String unitCode : allUnits.keySet()) {
      unitLister.addUnitToComboBox(allUnits.get(unitCode));
    }
  }

}
