package com.thoughtworks;

import com.thoughtworks.game.Board;
import com.thoughtworks.utility.ScannerObject;

import java.util.Scanner;

public class Driver {

    private Board board;

    public Driver(Board board) {
        this.board = board;
    }

    public static void main(String args[]) {
        Scanner sc = ScannerObject.getScannerObject();
        System.err.println("Please enter the number of times you want to play : ");
        int testCases = sc.nextInt();
        while (testCases-- != 0) {
            int cells = 0;
            do {
                try {
                    System.err.println("Please enter the number of cells greater than 2: ");
                    cells = sc.nextInt();
                } catch (Exception e) {
                    System.err.println("Please enter proper value");
                }
            } while (cells < 2);

            String charAllowed = "JHLE";
            char[] cellAttributes = new char[cells];
            for (int i = 0; i < cells; i++) {
                char ch = ' ';
                while (charAllowed.indexOf(ch + "") == -1) {
                    try {
                        System.err.println("Please enter the cell type which are : \n" +
                                "1. J -> Jail\n" +
                                "2. E -> Empty\n" +
                                "3. L -> Lottery\n" +
                                "4. H -> Hotel");
                        ch = sc.next().charAt(0);
                    } catch (Exception e) {
                        System.err.println("Please enter proper value");
                    }
                }
                cellAttributes[i] = ch;
            }

            int players = 0;
            do {
                try {
                    System.err.println("Please enter the number of players between 1 to 12: ");
                    players = sc.nextInt();
                } catch (Exception e) {
                    System.err.println("Please enter proper value");
                }
            } while (players < 1 && players > 12);

            String[] playerNames = new String[players];
            for (int i = 0; i < players; i++) {
                String name = null;
                while (name == null) {
                    try {
                        System.err.println("Please enter the name of Player " + (i + 1) + ": ");
                        name = sc.next();
                    } catch (Exception e) {
                        System.err.println("Please enter proper value");
                    }
                }
                playerNames[i] = name;

            }
            Board board = new Board(cells, cellAttributes, players, playerNames);
            Driver driver = new Driver(board);
            driver.game();
        }
    }

    public void game() {
        while (!board.isGameEnded()) {
            board.startGame();
        }
    }
}
