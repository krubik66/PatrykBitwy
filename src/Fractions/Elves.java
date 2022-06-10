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
        MeleeUnit bladedancer = Settings.Bladedancer();
        bladedancer.setAllegience(this);
        unitList.add(bladedancer);
        return bladedancer;
    }

    @Override
    public RangeUnit addRange() {
        RangeUnit bloodmage = Settings.Bloodmage();
        bloodmage.setAllegience(this);
        unitList.add(bloodmage);
        return bloodmage;
    }

    @Override
    public SpecialUnit addSpecial() {
        SpecialUnit portal = Settings.Portal();
        portal.setAllegience(this);
        unitList.add(portal);
        return portal;
    }
}
