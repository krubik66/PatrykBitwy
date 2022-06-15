package Battle_Map;

import Fractions.Units.Unit;
import settings.Settings;

import java.util.ArrayList;
import java.util.Random;

public class BattleMap {

    Tile[][] map;


    int occupiedPlacesSide1;
    int occupiedPlacesSide2;

    int maxCapacity;

    public BattleMap(int size) {

        map = new Tile[size][size];

        occupiedPlacesSide1 = 0;
        occupiedPlacesSide2 = 0;
        maxCapacity = size * size / 5;
        Create();
    }

    public boolean generateUnits(ArrayList<Unit> units, boolean fromNorth) {
        int size = map.length;
        if (!fromNorth) {
            if (units.size() + occupiedPlacesSide1 > maxCapacity) return false;
            for (Unit u : units) {
                int n = occupiedPlacesSide1 / size;
                Random random = new Random();
                while (true) {
                    int i = random.nextInt(size);
                    if (map[n][i].getUnit() == null) {
                        u.setPositionX(i);
                        u.setPositionY(n);
                        map[n][i].setUnit(u);
                        occupiedPlacesSide1++;
                        break;
                    }
                }
            }
        } else if (units.size() + occupiedPlacesSide2 > maxCapacity) return false;
        else {
            for (Unit u : units) {
                int n = size - 1 - occupiedPlacesSide2 / size;
                Random random = new Random();
                while (true) {
                    int i = random.nextInt(size);
                    if (map[n][i].getUnit() == null) {
                        u.setPositionX(i);
                        u.setPositionY(n);
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
        for (Tile[] row: map) {
            for (Tile title : row) {
                title.setTerrain(random.nextTerrain());
            }
        }
    }

    private void Create() {
        for(int i = 0; i < Settings.mapSize; i++) {
            for(int j = 0; j < Settings.mapSize; j++) {
                map[i][j] = new Tile();
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

    public void print() {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j].showYourself();
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }

    public void move(Unit unit, int x, int y) {
        if(map[y][x].getUnit() == null) {
            map[unit.getPositionY()][unit.getPositionX()].setUnit(null);
            map[y][x].setUnit(unit);
            unit.setPositionY(y);
            unit.setPositionX(x);
        }
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

    public Unit getUnit(int x, int y) {
        return map[y][x].getUnit();
    }
    public void unitDied(int x, int y) {
        map[y][x].setUnit(null);
        map[y][x].newBody();
    }
}
