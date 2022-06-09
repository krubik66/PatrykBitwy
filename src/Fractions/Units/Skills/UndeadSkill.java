package Fractions.Units.Skills;

import Fractions.Units.MeleeUnit;
import Fractions.Units.Unit;
import settings.Settings;

public class UndeadSkill implements Skill {
    @Override
    public void skill(Unit unit) {
        if(unit.getHp() < Settings.HP / 4) {
            MeleeUnit zombie = Settings.Zombie;
            zombie.setPositionX(unit.getPositionX());
            zombie.setPositionY(unit.getPositionY());
            unit = zombie;
        }
    }
}
