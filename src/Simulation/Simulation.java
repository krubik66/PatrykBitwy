package Simulation;

import Fractions.*;
import Fractions.Units.SpecialUnit;
import Fractions.Units.Unit;

public class Simulation {
    public Fraction northernFraction;
    public Fraction southernFraction;
    public Simulation(int north, int south) {
        switch (north) {
            case 1:
                this.northernFraction = new Humans(true);
                break;
            case 2:
                this.northernFraction = new Undead(true);
                break;
            case 3:
                this.northernFraction = new Elves(true);
                break;
            case 4:
                this.northernFraction = new Orcs(true);
                break;
        }
        switch (south) {
            case 1:
                this.southernFraction = new Humans(false);
                break;
            case 2:
                this.southernFraction = new Undead(false);
                break;
            case 3:
                this.southernFraction = new Elves(false);
                break;
            case 4:
                this.southernFraction = new Orcs(false);
                break;
        }
    }
    public void turn() {
        for(Object unit : northernFraction.getUnitList()) {
            boolean actionUsed = false;
            if(unit.getClass().equals(SpecialUnit.class)) actionUsed = UnitSkillUsage.attemptUsingASkill((SpecialUnit) unit);
            else actionUsed = UnitAttack.attack((Unit) unit);
            if(!actionUsed) UnitMovement.movement((Unit) unit);
        }

        for(Object unit : southernFraction.getUnitList()) {
            boolean actionUsed = false;
            if(unit.getClass().equals(SpecialUnit.class)) actionUsed = UnitSkillUsage.attemptUsingASkill((SpecialUnit) unit);
            else actionUsed = UnitAttack.attack((Unit) unit);
            if(!actionUsed) UnitMovement.movement((Unit) unit);
        }
    }
}
