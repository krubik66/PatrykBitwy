package Battle_Map;

import Fractions.Units.Unit;

public class BattleMap {

    Unit[][] map;
    int occupiedPlacesSide1;
    int occupiedPlacesSide2;

    int maxCapacity;
    public BattleMap(int size) {

        this.map = new Unit[size][size];

        occupiedPlacesSide1 = 0;
        occupiedPlacesSide2 = 0;
        maxCapacity = size*size/5;

    }

    public boolean generateUnits(Unit[] units, boolean onOppositeSide) {
        int size = map.length;
        if (onOppositeSide) {
            if (units.length + occupiedPlacesSide1 > maxCapacity) return false;
            int n = occupiedPlacesSide1/size;
            for (Unit u : units) {
                while (true) {

                }
            }
        }
    }
}
