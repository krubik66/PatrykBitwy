package Battle_Map;

import Fractions.Units.Unit;

public class Tile {
    private Terrain terrain;
    private Unit unit;

    private int deadBodies = 0;

    public Terrain getTerrain() {
        return terrain;
    }

    public int getDeadBodies() {
        return deadBodies;
    }

    public void setDeadBodies(int deadBodies) {
        this.deadBodies = deadBodies;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void newBody() {
        deadBodies++;
    }
}
