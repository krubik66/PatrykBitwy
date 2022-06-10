package Fractions.Units;

import Fractions.Units.Skills.Skill;

public class SpecialUnit extends Unit {
    private Skill skill;
    private int skillCD;
    private int remainingCD = 0;
    public SpecialUnit(int hp, int dmg, int speed, int range, Skill skill, int skillCD) {
        super(hp, dmg, speed);
        setRange(range);
        this.skill = skill;
        this.skillCD = skillCD;
    }
    public boolean tryToActivateSkill() {
        if(remainingCD == 0) {
            remainingCD = skillCD;
            activateSkill();
            return true;
        }
        else {
            remainingCD--;
            return false;
        }
    }
    public void activateSkill() {
        skill.skill(this);
    }
}
