package Fractions.Units;

import Fractions.Units.Skills.Skill;

public class SpecialUnit extends Unit {
    private Skill skill;
    public SpecialUnit(int hp, int dmg, int speed, int range, Skill skill) {
        super(hp, dmg, speed);
        setRange(range);
        this.skill = skill;
    }
    public void activateSkill(Unit unit) {
        skill.skill(unit);
    }
}
