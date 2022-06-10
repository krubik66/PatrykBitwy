package Fractions;

import Battle_Map.Title;
import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.Skills.UndeadPassive;
import Fractions.Units.SpecialUnit;
import settings.Settings;

public class Undead extends Fraction {
    private UndeadPassive passive = new UndeadPassive();
    public Undead(boolean isFromNorth) {
        super(isFromNorth);
    }

    public MeleeUnit addMelee() { return Settings.Zombie; }

    public RangeUnit addRange() {
        return Settings.SkeletonArcher;
    }

    public SpecialUnit addSpecial() {
        return Settings.Vampire;
    }

    public void passive(Title title) {
        passive.passive(title);
    }
}
