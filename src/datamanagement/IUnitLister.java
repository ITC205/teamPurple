package datamanagement;

/**
 * Clears and updates display of selected unit
 */
public interface IUnitLister
{
  //============================================================================
  // Methods
  //============================================================================



  /**
   * Clears display of units.
   */
  public void clearUnitsFromComboBox();



  /**
   * Displays selected unit.
   */
  public void addUnitToComboBox(IUnit unit);

}
