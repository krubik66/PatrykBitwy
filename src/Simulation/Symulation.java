package Simulation;

import Fractions.Elves;
import Fractions.Humans;
import Fractions.Orcs;
import Fractions.Undead;
import settings.CurrentGameData;
import settings.Settings;

public class Symulation {
    public Symulation(int first, int second) {
        switch (first) {
            case 1:
                CurrentGameData.northFraction = new Humans(true);
                break;
            case 2:
                CurrentGameData.northFraction = new Undead(true);
                break;
            case 3:
                CurrentGameData.northFraction = new Elves(true);
                break;
            case 4:
                CurrentGameData.northFraction = new Orcs(true);
                break;
        }
        switch (second) {
            case 1:
                CurrentGameData.northFraction = new Humans(false);
                break;
            case 2:
                CurrentGameData.northFraction = new Undead(false);
                break;
            case 3:
                CurrentGameData.northFraction = new Elves(false);
                break;
            case 4:
                CurrentGameData.northFraction = new Orcs(false);
                break;
        }
    }
    public static void turn() {

    }
}
