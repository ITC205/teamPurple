package datamanagement;

/**
 * Clears and updates display of selected unit
 */
public interface IUnitLister
{
  //===========================================================================
  // Methods
  //===========================================================================

  /**
   * Clears display of units.
   */
  public void clearAllUnits();



  /**
   * Displays selected unit.
   */
  public void addUnit(IUnit unit);



}
