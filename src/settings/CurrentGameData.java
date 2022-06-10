package settings;

import Battle_Map.BattleMap;
import Fractions.Fraction;

public class CurrentGameData {
    public static BattleMap battleMap = new BattleMap(Settings.mapSize);
    public static Fraction northFraction;
    public static Fraction southFraction;
}
