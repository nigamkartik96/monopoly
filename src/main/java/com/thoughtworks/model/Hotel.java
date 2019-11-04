package com.thoughtworks.model;

import com.thoughtworks.enums.HotelType;
import com.thoughtworks.game.Board;

public class Hotel extends Cell {

    private int ownerId;
    private HotelType type;

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public HotelType getType() {
        return type;
    }

    public void setType(HotelType type) {
        this.type = type;
    }

    public Hotel() {
        this.ownerId = 0;
        this.type = HotelType.SILVER;
    }

    @Override
    public void doAction(Player player, Board board) {
        if (this.ownerId < 1) {
            if (player.getMoney().getAmount() < type.getValue()) {
                if (player.getMoney().getAmount() < type.getRent()) {
                    System.err.println(player.getName() + " can't continue");
                    player.setCanContinue(false);
                    player.subMoney(type.getValue());
                    board.getBank().addMoney(type.getRent());
                    return;
                }

                System.out.println(player.getName() + " can't pay the value of hotel charging the rent " + type.getRent());
                player.subMoney(type.getRent());
                board.getBank().addMoney(type.getRent());
            } else {
                System.out.println(player.getName() + " pays " + type.getValue() + " for the hotel");
                player.subMoney(type.getValue());
                board.getBank().addMoney(type.getValue());
                this.ownerId = player.getId();
                player.addAssetAmount(type.getValue());
            }
        } else {
            if (player.getMoney().getAmount() < type.getValue()) {
                if (player.getMoney().getAmount() < type.getRent()) {
                    System.err.println(player.getName() + " can't continue");
                    player.setCanContinue(false);
                    player.subMoney(type.getValue());
                    board.getBank().addMoney(type.getRent());
                    return;
                }

                System.out.println(player.getName() + " can't pay the value of hotel charging the rent " + type.getRent());
                player.subMoney(type.getRent());
                board.getBank().addMoney(type.getRent());
            } else {
                System.out.println(player.getName() + " pays " + type.getRent() + " for the hotel");
                player.subMoney(type.getRent());
                board.getBank().addMoney(type.getRent());
                this.type = setHotelType();
                player.addAssetAmount(type.getRent());
            }
        }
    }

    private HotelType setHotelType() {
        switch (type) {
            case SILVER:
                return HotelType.GOLD;
            case GOLD:
                return HotelType.PLATINUM;
            default:
                return HotelType.SILVER;
        }
    }
}
