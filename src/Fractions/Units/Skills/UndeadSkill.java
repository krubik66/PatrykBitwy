package Fractions.Units.Skills;

import Fractions.Fraction;
import Fractions.Units.MeleeUnit;
import Fractions.Units.Unit;
import settings.Settings;

public class UndeadSkill implements Skill {
    @Override
    public void skill(Unit unit, Fraction allegience) {
        if(unit.getHp() < Settings.HP / 4) {
            MeleeUnit zombie = Settings.Zombie();
            zombie.setAllegience(allegience);
            allegience.getUnitList().add(zombie);
            zombie.setPositionX(unit.getPositionX());
            zombie.setPositionY(unit.getPositionY());
            unit = zombie;
        }
    }
}
