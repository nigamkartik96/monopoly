package com.thoughtworks.model;

import com.thoughtworks.constants.Constants;
import com.thoughtworks.game.Board;

public class Lottery extends Cell {
    @Override
    public void doAction(Player player, Board board) {
        System.out.println(player.getName() + " got a lottery of " + Constants.LOTTERY_PRICE);
        player.addMoney(Constants.LOTTERY_PRICE);
        board.getBank().subMoney(Constants.LOTTERY_PRICE);
    }
}
