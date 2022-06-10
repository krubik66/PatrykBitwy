package Fractions.Units.Skills;

import Fractions.Fraction;
import Fractions.Units.Unit;
import settings.Settings;

public class HumanSkill implements Skill{
    @Override
    public void skill(Unit unit, Fraction allegience) {
        if(unit.getAllegience().equals(allegience)) unit.setHp(unit.getHp() + Settings.HealAmount);
    }
}
