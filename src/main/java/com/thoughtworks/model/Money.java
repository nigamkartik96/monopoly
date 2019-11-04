package com.thoughtworks.model;

public class Money {
    private int amount;
    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addMoney(int money) {
        this.amount += money;
    }

    public void subMoney(int money) {
        this.amount -= money;
    }
}
