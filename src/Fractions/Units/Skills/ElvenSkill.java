package Fractions.Units.Skills;

import Battle_Map.BattleMap;
import Fractions.Fraction;
import Fractions.Units.Unit;
import settings.CurrentGameData;
import settings.Settings;

import java.util.Random;

public class ElvenSkill implements Skill{
    @Override
    public void skill(Unit unit, Fraction allegience) {
        Random random = new Random();
        int x = random.nextInt(Settings.mapSize);
        int y = random.nextInt(Settings.mapSize);
        CurrentGameData.battleMap.move(unit, x, y);
    }
}
