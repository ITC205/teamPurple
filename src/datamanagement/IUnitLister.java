package datamanagement;

/**
 * Displays (and clears) list of Units within GUI controls.
 */
public interface IUnitLister
{



  /**
   * Clears display of units.
   */
  public void clearUnitsFromComboBox();



  /**
   * Displays selected unit.
   * @param unit IUnit The Unit to be added to the comboBox list.
   */
  public void addUnitToComboBox(IUnit unit);

}
