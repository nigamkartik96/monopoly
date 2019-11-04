package com.thoughtworks.model;

import com.thoughtworks.game.Board;

public class Empty extends Cell {
    public void doAction(Player player, Board board) {
        System.out.println("No price deducted or credited for " + player.getName());
    }
}
