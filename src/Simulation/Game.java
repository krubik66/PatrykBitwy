package Simulation;

import Battle_Map.BattleMap;
import Fractions.Fraction;
import settings.CurrentGameData;
import settings.Settings;

import java.util.Scanner;
import java.util.Set;

public class Game {
    private boolean willToPlay = true;
    public Game() {
       while (willToPlay) this.willToPlay = fakeGame();
    }

    private static Symulation choosingFractions() {
        int north = fractionsInt(true);
        while(north < 1 || north > 4) {
            System.out.println("You choosed poorly");
            north = fractionsInt(true);
        }
        int south = fractionsInt(false);
        while(south < 1 || south > 4) {
            System.out.println("You choosed poorly");
            south = fractionsInt(false);
        }
        return new Symulation(north, south);
    }

    private static int fractionsInt(boolean isItNorth) {
        Scanner scanner = new Scanner(System.in);
        String arrow = "---> ";
        String chooses = "| Humans \t" + arrow +  " 1 |\n| Undead \t" + arrow +  " 2 |\n| Elves \t" + arrow +  " 3 |\n| Orcs \t\t" + arrow +  " 4 |\n";
        if(isItNorth) System.out.println(chooses + "Choose northern fraction: ");
        else System.out.println(chooses + "Choose southern fraction: ");
        return scanner.nextInt();
    }

    private boolean fillThoseRanks(Fraction fraction, boolean isNorth) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many melee: ");
        int meleeAmount = scanner.nextInt();
        System.out.println("How many ranged: ");
        int rangedAmount = scanner.nextInt();
        System.out.println("How many special: ");
        int specialAmount = scanner.nextInt();
        for(int i = 0; i < meleeAmount; i++) {
            fraction.addMelee();
        }
        for(int i = 0; i < rangedAmount; i++) {
            fraction.addRange();
        }
        for(int i = 0; i < specialAmount; i++) {
            fraction.addSpecial();
        }
        CurrentGameData.battleMap.generateUnits(fraction.getUnitList(), isNorth);
        return !fraction.getUnitList().isEmpty();
    }

    private static boolean again() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tAgain? ");
        int answer = 2;
        while (answer != 0 || answer != 1) {
            answer = scanner.nextInt();
        }
        if(answer == 1) return true;
        else return false;
    }

    public boolean startGame() {
        reset();
        Symulation currentSymulation = choosingFractions();
        System.out.println("Create northern army");
        fillThoseRanks(currentSymulation.northernFraction, true);
        System.out.println("Create southern army");
        fillThoseRanks(currentSymulation.southernFraction, false);
        while(currentSymulation.northernFraction.getUnitList().size() != 0 || currentSymulation.southernFraction.getUnitList().size() != 0) {
            currentSymulation.turn();
            CurrentGameData.battleMap.print();
        }
        return again();
    }

    public boolean fakeGame() {
        reset();
        Symulation currentSymulation = choosingFractions();
        fakeFill(currentSymulation.northernFraction, true);
        fakeFill(currentSymulation.southernFraction, false);
        while(currentSymulation.northernFraction.getUnitList().size() != 0 || currentSymulation.southernFraction.getUnitList().size() != 0) {
            currentSymulation.turn();
            CurrentGameData.battleMap.print();
        }
        System.out.println("");
        return again();
    }

    private void reset() {
        CurrentGameData.battleMap = new BattleMap(Settings.mapSize);;
    }

    private boolean fakeFill(Fraction fraction, boolean isNorth) {
        for(int i = 0; i < 3; i++) {
            fraction.addMelee();
        }
        for(int i = 0; i < 2; i++) {
            fraction.addRange();
        }
        for(int i = 0; i < 1; i++) {
            fraction.addSpecial();
        }
        CurrentGameData.battleMap.generateUnits(fraction.getUnitList(), isNorth);
        return !fraction.getUnitList().isEmpty();
    }
}
