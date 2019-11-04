package com.thoughtworks.game;

import com.thoughtworks.constants.Constants;
import com.thoughtworks.model.Bank;
import com.thoughtworks.model.Cell;
import com.thoughtworks.model.Empty;
import com.thoughtworks.model.Hotel;
import com.thoughtworks.model.Jail;
import com.thoughtworks.model.Lottery;
import com.thoughtworks.model.Player;
import com.thoughtworks.utility.ScannerObject;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Board {
    private int cells;
    private char[] cellValues;
    private int noOfPlayers;
    private Player players[];
    private boolean gameEnded;
    private Bank bank;
    private Set<Hotel> hotelSet;

    public Bank getBank() {
        return this.bank;
    }

    public Player getPlayer(int id) {
        for (int i = 0; i < noOfPlayers; i++) {
            if (players[i].getId() == id) return players[i];
        }
        return null;
    }

    public Board(int cells, char[] cellValues, int noOfPlayers, String[] playerNames) {
        this.cells = cells;
        this.cellValues = cellValues;
        this.noOfPlayers = noOfPlayers;
        this.players = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            this.players[i] = new Player(playerNames[i], 0, 0, i + 1);
        }
        this.gameEnded = false;
        this.bank = new Bank();
        hotelSet = new HashSet<>();
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void startGame() {
        for (int currentChance = 0; currentChance < Constants.TOTAL_CHANCES; currentChance++) {
            for (int currentPlayer = 0; currentPlayer < noOfPlayers; currentPlayer++) {
                if (players[currentPlayer].canContinue()) {
                    int dice = getDiceValue(players[currentPlayer]);
                    players[currentPlayer].setTotalSteps(dice);
                    players[currentPlayer].setCurrentPosition(cells);
                    action(players[currentPlayer]);
                }
            }
        }
        for (int currentPlayer = 0; currentPlayer < noOfPlayers; currentPlayer++)
            System.out.println(players[currentPlayer]);
        System.out.println(bank);

        this.gameEnded = true;
    }

    private void action(Player player) {
        char cellName = cellValues[player.getCurrentPosition() - 1];
        Cell cell;
        switch (cellName) {
            case 'E':
                cell = new Empty();
                cell.doAction(player, this);
                break;
            case 'H':
                Hotel hotel = getHotel(player);
                hotelSet.add(hotel);
                hotel.doAction(player, this);
                break;
            case 'J':
                cell = new Jail();
                cell.doAction(player, this);
                break;
            case 'L':
                cell = new Lottery();
                cell.doAction(player, this);
                break;
            default:
                System.err.println("Wrong input of cell");
        }
    }

    private Hotel getHotel(Player player) {
        for (Hotel hotel : hotelSet) {
            if (hotel.getOwnerId() == player.getId()) return hotel;
        }

        return new Hotel();
    }

    private int getDiceValue(Player player) {
        Scanner sc = ScannerObject.getScannerObject();
        System.err.println("Please enter a value of dice between 1 to 12 for player " + player.getName());
        int dice = sc.nextInt();
        return dice;
    }

    public void addMoneyToBank(int price) {
        bank.addMoney(price);
    }
}
