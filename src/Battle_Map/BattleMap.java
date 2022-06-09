package Battle_Map;

import Fractions.Units.Unit;

import java.util.Random;

public class BattleMap {

    Title[][] map;


    int occupiedPlacesSide1;
    int occupiedPlacesSide2;

    int maxCapacity;

    public BattleMap(int size) {

        map = new Title[size][size];

        occupiedPlacesSide1 = 0;
        occupiedPlacesSide2 = 0;
        maxCapacity = size * size / 5;

    }

    public boolean generateUnits(Unit[] units, boolean onOppositeSide) {
        int size = map.length;
        if (!onOppositeSide) {
            if (units.length + occupiedPlacesSide1 > maxCapacity) return false;
            for (Unit u : units) {
                int n = occupiedPlacesSide1 / size;
                Random random = new Random();
                while (true) {
                    int i = random.nextInt(size);
                    if (map[n][i].getUnit() == null) {
                        u.setPositionX(i);
                        u.setPositionY(n);
                        u.setFromNorth(true);
                        map[n][i].setUnit(u);
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
                    if (map[n][i].getUnit() == null) {
                        u.setPositionX(i);
                        u.setPositionY(n);
                        u.setFromNorth(false);
                        map[n][i].setUnit(u);
                        occupiedPlacesSide1++;
                        break;
                    }
                }
            }
        }
        return true;
    }

    public void generateTerrain(int biome) {
        RandomTerrain random = new RandomTerrain();
        for (Title[] row: map) {
            for (Title title : row) {
                title.setTerrain(random.nextTerrain());
            }
        }
    }

    public void printMap() {
        StringBuilder[] stringBuilders = new StringBuilder[map.length*3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                String[] toAppend = new String[3];
                if (j%2==0 && i%2 == 0) {
                    if (j==0) {
                        stringBuilders[i*3].append("  ");
                        stringBuilders[i*3+1].append(' ');
                    }
                    toAppend = printUnit(map[i][j].getUnit());
                } else if (j%2==1 && i%2 == 0) {
                    if (i==0) {
                        toAppend = printTop();
                    } else toAppend = printTerrain(map[i][j].getTerrain());

                } else if (j%2==0 && i%2 == 1) {
                    if (j==0) {
                        stringBuilders[i*3+2].append("  ");
                        stringBuilders[i*3+1].append(' ');
                    }
                    toAppend = printTerrain(map[i][j].getTerrain());
                } else if (j%2==1 && i%2 == 1) {
                    if (i == map.length) toAppend = printBottom();
                    else toAppend = printUnit(map[i][j].getUnit());
                }
                stringBuilders[i*3].append(toAppend[0]);
                stringBuilders[i*3+1].append(toAppend[1]);
                stringBuilders[i*3+2].append(toAppend[2]);
            }
        }
    }

    public void move(Unit unit, int x, int y) {
        map[unit.getPositionY()][unit.getPositionX()].setUnit(null);
        map[y][x].setUnit(unit);
        unit.setPositionY(y);
        unit.setPositionX(x);
    }

    public boolean remove(Unit unit) {
        map[unit.getPositionY()][unit.getPositionX()].newBody();
        return false;
    }

    public String[] printTop() {
        String s = "\\";
        return new String[]{s+"            ",s+"          ",s+"        "};
    }

    public String[] printBottom() {
        String s = "////";
        return new String[]{s+"        ",s+"          ",s+"            "};
    }

    public String[] printUnit(Unit unit) {
        String s = "////";

        return new String[]{s+"        ",s+"          ",s+"            "};
    }

    public String[] printTerrain(Terrain terrain) {
        return null;
    }
}
