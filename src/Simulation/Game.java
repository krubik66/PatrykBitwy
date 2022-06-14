package Simulation;

import java.util.Scanner;

public class Game {
    public static void startGame() {
        Symulation Game = choosingFractions();

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
        String chooses = "| Humans - 1 |\n| Undead - 2 |\n| Elves - 3 |\n| Orcs - 4 |\n";
        if(isItNorth) System.out.println(chooses + "\tChoose northern fraction: ");
        else System.out.println(chooses + "\tChoose southern fraction: ");
        return scanner.nextInt();
    }
}
