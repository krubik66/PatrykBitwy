package Fractions.Units.Skills;

import Battle_Map.BattleMap;
import Battle_Map.Title;
import Fractions.Fraction;
import Fractions.Units.Unit;
import Simulation.UnitAttack;
import settings.CurrentGameData;
import settings.Settings;

import java.util.ArrayList;
import java.util.Random;

public class ElvenSkill implements Skill{
    @Override
    public boolean skill(Unit caster) {
        Unit target = UnitAttack.findTarget(caster, false);
        if(target != null) {
            Random random = new Random();
            int x = random.nextInt(Settings.mapSize);
            int y = random.nextInt(Settings.mapSize);
            CurrentGameData.battleMap.move(target, x, y);
            return true;
        }
        else return false;
    }
}
