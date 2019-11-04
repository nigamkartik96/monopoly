package com.thoughtworks.model;

import com.thoughtworks.game.Board;

public abstract class Cell {
    public abstract void doAction(Player player, Board board);
}
