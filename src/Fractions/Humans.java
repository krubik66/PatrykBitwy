package Fractions;

import Fractions.Units.MeleeUnit;
import Fractions.Units.RangeUnit;
import Fractions.Units.SpecialUnit;
import settings.Settings;

public class Humans extends Fraction {
    public Humans(boolean isFromNorth) {
        super(isFromNorth);
    }

    @Override
    public MeleeUnit addMelee() {
        MeleeUnit paladin = Settings.Paladin();
        paladin.setAlliance(this);
        unitList.add(paladin);
        return paladin;
    }

    @Override
    public RangeUnit addRange() {
        RangeUnit marksman = Settings.Marksman();
        marksman.setAlliance(this);
        unitList.add(marksman);
        return marksman;
    }

    @Override
    public SpecialUnit addSpecial() {
        SpecialUnit priest = Settings.Priest();
        priest.setAlliance(this);
        unitList.add(priest);
        return priest;
    }
}
