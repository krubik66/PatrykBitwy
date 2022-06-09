package Fractions;

import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import settings.Settings;

public class Undead extends Fraction {

    public static MeleeUnit addMelee() {
        return Settings.Zombie;
    }

    public static RangeUnit addRange() {
        return Settings.SkeletonArcher;
    }

    public static SpecialUnit addSpecial() {
        return Settings.Vampire;
    }
}
