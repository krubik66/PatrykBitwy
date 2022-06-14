package Simulation;

import Fractions.Elves;
import Fractions.Humans;
import Fractions.Orcs;
import Fractions.Undead;
import Fractions.Units.SpecialUnit;
import Fractions.Units.Unit;
import settings.CurrentGameData;
import settings.Settings;

public class Symulation {
    public Symulation(int north, int south) {
        switch (north) {
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
        switch (south) {
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
        for(Object unit : CurrentGameData.northFraction.getUnitList()) {
            boolean actionUsed = false;
            if(unit.getClass().equals(SpecialUnit.class)) actionUsed = UnitSkillUsage.attemptUsingASkill((SpecialUnit) unit);
            else actionUsed = UnitAttack.attack((Unit) unit);
            if(!actionUsed) UnitMovement.movement((Unit) unit);
        }

        for(Object unit : CurrentGameData.southFraction.getUnitList()) {
            boolean actionUsed = false;
            if(unit.getClass().equals(SpecialUnit.class)) actionUsed = UnitSkillUsage.attemptUsingASkill((SpecialUnit) unit);
            else actionUsed = UnitAttack.attack((Unit) unit);
            if(!actionUsed) UnitMovement.movement((Unit) unit);
        }
    }
}
