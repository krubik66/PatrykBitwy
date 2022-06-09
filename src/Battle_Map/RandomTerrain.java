package Battle_Map;

import java.util.Random;

public class RandomTerrain extends Random {

    //TODO
    Terrain[] terrains = {};

    public Terrain nextTerrain() {
        //TODO
        return terrains[nextInt(4)];
    }
}
