package datamanagement;

/**
 *
 */
public class ListUnitsCTL
{
  //===========================================================================
  // Variables
  //===========================================================================

  private UnitManager um;

  //===========================================================================
  // Constructors
  //===========================================================================

  /**
   * Creates new instance and references singleton UnitManager instance
   * in order to access the collection of units.
   */
  public ListUnitsCTL() {
    um = UnitManager.UM();
  }



  //===========================================================================
  // Methods
  //===========================================================================

  /**
   *
   */
  public void listUnits(IUnitLister lister)
  {
    lister.clearUnits();
    UnitMap units = um.getUnits();
    for (String s : units.keySet()) {
      lister.addUnit(units.get(s));
    }
  }



}
