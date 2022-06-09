package Fractions.Units.Skills;

import Fractions.Units.Unit;
import settings.Settings;

import java.util.Random;

public class ElvenSkill implements Skill{
    @Override
    public void skill(Unit unit) {
        Random random = new Random();
        int x = random.nextInt(Settings.mapSize);
        int y = random.nextInt(Settings.mapSize);
        move(unit, x, y);
    }
}
