package com.thoughtworks.model;

import com.thoughtworks.constants.Constants;
import com.thoughtworks.game.Board;

public class Jail extends Cell {
    @Override
    public void doAction(Player player, Board board) {
        if (player.getMoney().getAmount() < Constants.JAIL_FINE) {
            player.subMoney(Constants.JAIL_FINE);
            player.setCanContinue(false);
            System.err.println(player.getName() + " went broke!");
        } else {
            System.out.println(player.getName() + " lost " + Constants.JAIL_FINE + " in Jail");
            player.subMoney(Constants.JAIL_FINE);
            board.addMoneyToBank(Constants.JAIL_FINE);
        }
    }
}
