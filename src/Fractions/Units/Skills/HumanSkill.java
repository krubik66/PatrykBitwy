package Fractions.Units.Skills;

import Fractions.Fraction;
import Fractions.Units.Unit;
import Simulation.UnitAttack;
import settings.Settings;

import java.util.ArrayList;

public class HumanSkill implements Skill{
    @Override
    public boolean skill(Unit caster) {
        ArrayList targets = UnitAttack.findTargets(caster, true);
        if(targets.isEmpty()) return false;
        for(Object target : targets) {
            ((Unit) target).setHp(Math.max(((Unit) target).getHp() + Settings.HealAmount, ((Unit) target).getMaxHP()));
        }
        return true;
    }
}
