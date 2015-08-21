package datamanagement;

/**
 * Displays (and clears) list of Units within GUI controls.
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
