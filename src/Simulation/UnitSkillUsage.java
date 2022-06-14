package Simulation;

import Fractions.Units.SpecialUnit;

public class UnitSkillUsage {
    public static boolean attemptUsingASkill(SpecialUnit caster) {
        if(!caster.tryToActivateSkill()) {
            boolean attacked = UnitAttack.attack(caster);
            return attacked;
        }
        return true;
    }
}
