package settings;

import Battle_Map.BattleMap;
import Fractions.Fraction;

public class CurrentGameData {
    public static BattleMap battleMap = new BattleMap(Settings.mapSize);
    public static boolean isCurrentlyOngoing = false;
    public static boolean hasStarted = false;
    public static int attackingFractionNumber = 0;
    public static int defendingFractionNumber = 0;

}
