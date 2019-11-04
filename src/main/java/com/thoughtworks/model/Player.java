package com.thoughtworks.model;

import com.thoughtworks.constants.Constants;

public class Player {
    private String name;
    private int totalSteps;
    private int currentPosition;
    private int id;
    private Money assetMoney = new Money(0);
    private Money money = new Money(Constants.INITIAL_AMOUNT_PLAYER);
    private boolean canContinue;

    public Player() {
    }

    public void addMoney(int price) {
        this.money.addMoney(price);
    }

    public void subMoney(int price) {
        this.money.subMoney(price);
    }

    public Player(String name, int totalSteps, int currentPosition, int id) {
        this.name = name;
        this.totalSteps = totalSteps;
        this.currentPosition = currentPosition;
        this.id = id;
        this.money = new Money(Constants.INITIAL_AMOUNT_PLAYER);
        this.assetMoney = new Money(0);
        this.canContinue = true;
    }

    public boolean canContinue() {
        return canContinue;
    }

    public void setCanContinue(boolean canContinue) {
        this.canContinue = canContinue;
    }

    public Money getAssetMoney() {
        return assetMoney;
    }

    public void setAssetMoney(Money assetMoney) {
        this.assetMoney = assetMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps += totalSteps;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int cells) {
        this.currentPosition = this.totalSteps % cells;
        if (this.currentPosition == 0) this.currentPosition = cells;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void addAssetAmount(int price) {
        this.assetMoney.addMoney(price);
    }

    @Override
    public String toString() {
        return this.name + " has total money " + this.money.getAmount() +
                " and asset of amount: " + this.assetMoney.getAmount();
    }
}
