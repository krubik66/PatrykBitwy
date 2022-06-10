package Fractions.Units.Skills;

import Fractions.Fraction;
import Fractions.Units.Unit;
import Simulation.UnitAttack;

import java.util.ArrayList;

public class OrcSkill implements Skill {
    @Override
    public boolean skill(Unit caster) {
        ArrayList targets = UnitAttack.findTargets(caster, false);
        if(targets.isEmpty()) return false;
        for(Object target : targets) {
            ((Unit) target).poison();
        }
        return true;
    }
}
