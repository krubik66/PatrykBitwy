package Battle_Map;

import Fractions.Units.Unit;

import java.util.Random;

public class BattleMap {

    Unit[][] unitPosition;

    Terrain[][] mapTerrain;
    int occupiedPlacesSide1;
    int occupiedPlacesSide2;

    int maxCapacity;

    public BattleMap(int size) {

        this.unitPosition = new Unit[size][size];
        this.mapTerrain = new Terrain[size][size];

        occupiedPlacesSide1 = 0;
        occupiedPlacesSide2 = 0;
        maxCapacity = size * size / 5;

    }

    public boolean generateUnits(Unit[] units, boolean onOppositeSide) {
        int size = unitPosition.length;
        if (!onOppositeSide) {
            if (units.length + occupiedPlacesSide1 > maxCapacity) return false;
            for (Unit u : units) {
                int n = occupiedPlacesSide1 / size;
                Random random = new Random();
                while (true) {
                    int i = random.nextInt(size);
                    if (unitPosition[n][i] == null) {
                        u.setPositionX(i);
                        u.setPositionY(n);
                        unitPosition[n][i] = u;
                        occupiedPlacesSide1++;
                        break;
                    }
                }
            }
        } else if (units.length + occupiedPlacesSide2 > maxCapacity) return false;
        else {
            for (Unit u : units) {
                int n = size - occupiedPlacesSide2 / size;
                Random random = new Random();
                while (true) {
                    int i = random.nextInt(size);
                    if (unitPosition[n][i] == null) {
                        u.setPositionX(i);
                        u.setPositionY(n);
                        unitPosition[n][i] = u;
                        occupiedPlacesSide2++;
                        break;
                    }
                }
            }
        }
        return true;
    }

    public void generateTerrain(int biome) {
        RandomTerrain random = new RandomTerrain();
        for (Terrain[] row: mapTerrain) {
            for (Terrain place: row) {
                place = random.nextTerrain();
            }
        }
    }
}
