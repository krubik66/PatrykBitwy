package Battle_Map;

import Fractions.Units.Unit;

public class BattleMap {

    Unit[][] map;

    public BattleMap(int size) {
        this.map = new Unit[size][size];
    }

    public boolean generateUnits(Unit unit) {
        return false;
    }
}
