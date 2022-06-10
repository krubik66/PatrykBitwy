package Fractions;

import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import settings.Settings;

public class Elves extends Fraction {

    public Elves(boolean isFromNorth) {
        super(isFromNorth);
    }

    @Override
    public MeleeUnit addMelee() {
        return Settings.Bladedancer;
    }

    @Override
    public RangeUnit addRange() {
        return Settings.Bloodmage;
    }

    @Override
    public SpecialUnit addSpecial() {
        return Settings.Portal;
    }
}
