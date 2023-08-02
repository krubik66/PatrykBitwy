package Simulation;

import Battle_Map.BattleMap;
import Fractions.Fraction;
import GUI.MapPanel;
import GUI.ChoosingFractionsPanel;
import GUI.MyPanel2;
import settings.CurrentGameData;
import settings.Settings;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private boolean willToPlay = true;

    private JFrame frame;
    private ChoosingFractionsPanel panel1;
    private MapPanel panel2;
    public Game() {

        frame = new JFrame("My plane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        int a = Settings.mapSize;
        try {
            panel1 = new ChoosingFractionsPanel("Picture.jpeg");
            panel2 = new MapPanel(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JPanel panel = new MyPanel2(panel1,panel2);
        frame.getContentPane().add(panel);
        frame.setVisible(true);


        while (willToPlay) this.willToPlay = fakeGame();
    }

    private Simulation choosingFractions() {
        //int north = fractionsInt(true);
        while (!CurrentGameData.hasStarted) {
            synchronized (this) {
                try {
                    wait(1);
                } catch (InterruptedException e) {
                    System.out.println("Dont interrupt");
                }
            }
        }
        int north = CurrentGameData.attackingFractionNumber;
        while(north < 1 || north > 4) {
            System.out.println("You choosed poorly");
            //north = fractionsInt(true);
            north = CurrentGameData.attackingFractionNumber;
        }
        //int south = fractionsInt(false);
        int south = CurrentGameData.defendingFractionNumber;
        while(south < 1 || south > 4) {
            System.out.println("You choosed poorly");
            //south = fractionsInt(false);
            south = CurrentGameData.attackingFractionNumber;
        }
        return new Simulation(north, south);
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
        return !CurrentGameData.battleMap.generateUnits(fraction.getUnitList(), isNorth);
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
        Simulation currentSimulation = choosingFractions();
        System.out.println("Create northern army");
        fillThoseRanks(currentSimulation.northernFraction, true);
        System.out.println("Create southern army");
        fillThoseRanks(currentSimulation.southernFraction, false);
        panel2.refresh();
        while(currentSimulation.northernFraction.getUnitList().size() != 0 && currentSimulation.southernFraction.getUnitList().size() != 0) {
            currentSimulation.turn();
            panel2.refresh();
            CurrentGameData.battleMap.print();
            try {
                wait(1000);
            } catch (InterruptedException e) {
                System.out.println("Dont interrupt");
            }
        }
        return again();
    }

    public boolean fakeGame() {
        reset();
        Simulation currentSimulation = choosingFractions();
        fakeFill(currentSimulation.northernFraction, true);
        fakeFill(currentSimulation.southernFraction, false);
        while(currentSimulation.northernFraction.getUnitList().size() != 0 || currentSimulation.southernFraction.getUnitList().size() != 0) {
            if(CurrentGameData.isCurrentlyOngoing) {
                currentSimulation.turn();
                panel2.refresh();
                CurrentGameData.battleMap.print();
                synchronized (this) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Dont interrupt");
                    }
                }
            }
            else {
                synchronized (this) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Dont interrupt");
                    }
                }
            }
        }
        System.out.println("");
        return again();
    }

    private void reset() {
        CurrentGameData.battleMap = new BattleMap(Settings.mapSize);
        panel2.refresh();
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
