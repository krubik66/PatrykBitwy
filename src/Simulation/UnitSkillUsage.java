package Simulation;

import Fractions.Units.SpecialUnit;

public class UnitSkillUsage {
    public static void attemptUsingASkill(SpecialUnit caster) {
        if(!caster.tryToActivateSkill()) UnitAttack.attack(caster);
    }
}
