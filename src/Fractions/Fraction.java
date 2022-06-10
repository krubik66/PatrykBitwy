package Fractions;

import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import Fractions.Units.Unit;

import java.util.ArrayList;

public abstract class Fraction {
    private boolean isFromNorth;
    protected ArrayList unitList = new ArrayList();
    public Fraction(boolean isFromNorth) {
        this.isFromNorth = isFromNorth;
    }

    public abstract MeleeUnit addMelee();

    public abstract RangeUnit addRange();

    public abstract SpecialUnit addSpecial();


    public ArrayList getUnitList() {
        return unitList;
    }
    public void unitDied(Unit unit) {
        unitList.remove(unit);
    }
}
