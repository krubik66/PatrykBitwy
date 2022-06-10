package Fractions.Units.Skills;

import Fractions.Fraction;
import Fractions.Units.Unit;

public class OrcSkill implements Skill {
    @Override
    public void skill(Unit unit, Fraction allegience) {
        if(!unit.getAllegience().equals(allegience)) unit.poison();
    }
}
