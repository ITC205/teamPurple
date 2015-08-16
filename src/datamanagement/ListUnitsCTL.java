package datamanagement;
public class ListUnitsCTL {
    private UnitManager um;
public ListUnitsCTL() {
        um = UnitManager.getInstance();
}
            public void listUnits( IUnitLister lister ) {
lister.clearUnitsFromComboBox();UnitMap units = um.getUnits();
        for (String s : units.keySet() )
            lister.addUnitToComboBox(units.get(s));}}
