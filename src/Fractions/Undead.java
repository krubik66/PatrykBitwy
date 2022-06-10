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

    public MeleeUnit addMelee() {
        MeleeUnit zombie = Settings.Zombie();
        zombie.setAllegience(this);
        unitList.add(zombie);
        return zombie;
    }

    public RangeUnit addRange() {
        RangeUnit skeletonArcher = Settings.SkeletonArcher();
        skeletonArcher.setAllegience(this);
        unitList.add(skeletonArcher);
        return skeletonArcher;
    }

    public SpecialUnit addSpecial() {
        SpecialUnit vampire = Settings.Vampire();
        vampire.setAllegience(this);
        unitList.add(vampire);
        return vampire;
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
