package Simulation;

import Fractions.Units.SpecialUnit;

public class UnitSkillUsage {
    public static boolean attemptUsingASkill(SpecialUnit caster) {
        if(!caster.tryToActivateSkill()) return UnitAttack.attack(caster);
        return true;
    }
}
