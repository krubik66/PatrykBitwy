package Simulation;

import Fractions.Units.Unit;
import settings.CurrentGameData;
import settings.Settings;

import java.util.ArrayList;

public class UnitAttack {
    public static Unit findTarget(Unit caster, boolean friendly) {
        int range = Math.max(caster.getRange(), 1);
        for (int x = caster.getPositionX() - range; x < caster.getPositionX() + range; x++) {
            for (int y = caster.getPositionY() - range; y < caster.getPositionY() + range; y++) {
                if(x >= 0 && x < Settings.mapSize && y >= 0 && y < Settings.mapSize) {
                    Unit currentUnit = CurrentGameData.battleMap.getUnit(x, y);
                    if (currentUnit != null && currentUnit.getAlliance().equals(caster.getAlliance()) == friendly) {
                        return currentUnit;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList findTargets(Unit caster, boolean friendly) {
        ArrayList targets = new ArrayList();
        int range = Math.max(caster.getRange(), 1);
        for (int x = caster.getPositionX() - range; x < caster.getPositionX() + range; x++) {
            for (int y = caster.getPositionY() - range; y < caster.getPositionY() + range; y++) {
                if(x >= 0 && x < Settings.mapSize && y >= 0 && y < Settings.mapSize) {
                    Unit currentUnit = CurrentGameData.battleMap.getUnit(x, y);
                    if (currentUnit != null && currentUnit.getAlliance().equals(caster.getAlliance()) == friendly) {
                        targets.add(currentUnit);
                    }
                }
            }
        }
        return targets;
    }

    public static boolean attack(Unit attacker) {
        Unit target = findTarget(attacker, false);
        if(target != null) {
            target.setHp(target.getHp() - attacker.getDmg());
            if(target.getHp() <= 0) {
                target.getAlliance().unitDied(target);
                int x = target.getPositionX();
                int y = target.getPositionY();
                CurrentGameData.battleMap.unitDied(x, y);
            }
            return true;
        }
        return false;
    }
}
