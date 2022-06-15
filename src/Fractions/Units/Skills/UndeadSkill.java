package Fractions.Units.Skills;

import Fractions.Units.MeleeUnit;
import Fractions.Units.Unit;
import Simulation.UnitAttack;
import settings.Settings;

public class UndeadSkill implements Skill {
    @Override
    public boolean skill(Unit caster) {
        Unit target = UnitAttack.findTarget(caster, false);
        if(target != null && target.getHp() < Settings.HP / 4) {
            MeleeUnit zombie = Settings.Zombie();
            zombie.setAlliance(caster.getAlliance());
            caster.getAlliance().getUnitList().add(zombie);
            zombie.setPositionX(target.getPositionX());
            zombie.setPositionY(target.getPositionY());
            target = zombie;
            return true;
        }
        return false;
    }
}
