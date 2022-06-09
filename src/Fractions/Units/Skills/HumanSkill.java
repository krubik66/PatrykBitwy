package Fractions.Units.Skills;

import Fractions.Units.Unit;
import settings.Settings;

public class HumanSkill implements Skill{
    @Override
    public void skill(Unit unit) {
        unit.setHp(unit.getHp() + Settings.Heal);
    }
}
