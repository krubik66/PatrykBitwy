package Fractions;

import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import Fractions.Units.Unit;

public abstract class Fraction {
    private boolean isFromNorth;
    public Fraction(boolean isFromNorth) {
        this.isFromNorth = isFromNorth;
    }

    public abstract MeleeUnit addMelee();

    public abstract RangeUnit addRange();

    public abstract SpecialUnit addSpecial();
}
