package Fractions;

import Battle_Map.Title;
import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import settings.Settings;

public class Undead extends Fraction {
    public Undead(boolean isFromNorth) {
        super(isFromNorth);
    }

    public MeleeUnit addMelee() { return Settings.Zombie(); }

    public RangeUnit addRange() {
        return Settings.SkeletonArcher();
    }

    public SpecialUnit addSpecial() {
        return Settings.Vampire();
    }

    public void passive(Title title) {
        if(title.getDeadBodies() >= Settings.bodiesRequiredToResurrect && title.getUnit() == null) {
            title.setDeadBodies(0);
            MeleeUnit zombie = Settings.Zombie();
            zombie.setAllegience(this);
            unitList.add(zombie);
            title.setUnit(zombie);
        }
    }
}
