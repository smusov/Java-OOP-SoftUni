package jediGalaxyRefactor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseInput(scanner.nextLine());

        Galaxy galaxy = new Galaxy(dimensions[0],dimensions[1]);

        Player player = new Player();
        Evil evil = new Evil();

        Game game = new Game(player,evil,galaxy);

        String command;

        while (!"Let the Force be with you".equals(command = scanner.nextLine())) {

            int[] playerRowCol = parseInput(command);

            player.setRow(playerRowCol[0]);
            player.setCol(playerRowCol[1]);

            int[] evilRowCol = parseInput(scanner.nextLine());

            evil.setRow(evilRowCol[0]);
            evil.setCol(evilRowCol[1]);

            game.startGame();

        }

        System.out.println(player.getPoints());

    }

    private static int[] parseInput (String input){
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
