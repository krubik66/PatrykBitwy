package Fractions.Units.Skills;

import Fractions.Units.Unit;

public class OrcSkill implements Skill {
    @Override
    public void skill(Unit unit) {
        unit.poison();
    }
}
