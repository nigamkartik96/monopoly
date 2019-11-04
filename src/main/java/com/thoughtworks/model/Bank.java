package com.thoughtworks.model;

import com.thoughtworks.constants.Constants;

public class Bank {
    private Money money;

    public Money getMoney() {
        return money;
    }

    public void addMoney(int price) {
        this.money.addMoney(price);
    }

    public void subMoney(int price) {
        this.money.subMoney(price);
    }

    public Bank() {
        this.money = new Money(Constants.INITIAL_AMOUNT_BANK);
    }

    @Override
    public String toString() {
        return "Balance at Bank: " + this.money.getAmount();
    }
}
