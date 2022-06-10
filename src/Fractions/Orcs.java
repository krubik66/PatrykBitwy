package Fractions;

import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import settings.Settings;

public class Orcs extends Fraction {
    public Orcs(boolean isFromNorth) {
        super(isFromNorth);
    }

    @Override
    public MeleeUnit addMelee() {
        MeleeUnit grunt = Settings.Grunt();
        grunt.setAllegience(this);
        unitList.add(grunt);
        return grunt;
    }

    @Override
    public RangeUnit addRange() {
        RangeUnit hunter = Settings.Hunter();
        hunter.setAllegience(this);
        unitList.add(hunter);
        return hunter;
    }

    @Override
    public SpecialUnit addSpecial() {
        SpecialUnit shaman = Settings.Shaman();
        shaman.setAllegience(this);
        unitList.add(shaman);
        return shaman;
    }
}
