package datamanagement;

/**
 * Controls the list of Units that is displayed within the GUI controls.
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
   * Returns the singleton UnitManager instance that holds the collection of
   * units.
   * @return UnitManager Returns the UnitManager instance that holds the
   * collection of units.
   */
  private UnitManager getUnitManager()
  {
    return unitManager_;
  }



  //============================================================================
  // Methods
  //============================================================================



  /**
   * Updates the list of Units that is displayed within the GUI controls.
   * @param unitLister IUnitLister The GUI control that displays the list of
   *                   Units.
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
