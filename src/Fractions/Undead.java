package Fractions;

import Battle_Map.Tile;
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
        zombie.setAlliance(this);
        unitList.add(zombie);
        return zombie;
    }

    public RangeUnit addRange() {
        RangeUnit skeletonArcher = Settings.SkeletonArcher();
        skeletonArcher.setAlliance(this);
        unitList.add(skeletonArcher);
        return skeletonArcher;
    }

    public SpecialUnit addSpecial() {
        SpecialUnit vampire = Settings.Vampire();
        vampire.setAlliance(this);
        unitList.add(vampire);
        return vampire;
    }

    public void passive(Tile title) {
        if(title.getDeadBodies() >= Settings.bodiesRequiredToResurrect && title.getUnit() == null) {
            title.setDeadBodies(0);
            MeleeUnit zombie = Settings.Zombie();
            zombie.setAlliance(this);
            unitList.add(zombie);
            title.setUnit(zombie);
        }
    }
}
