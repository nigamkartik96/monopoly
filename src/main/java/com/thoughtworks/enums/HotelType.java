package com.thoughtworks.enums;

import com.thoughtworks.constants.Constants;

public enum HotelType {
    SILVER(Constants.SILVER_PRICE, Constants.SILVER_RENT),
    GOLD(Constants.GOLD_PRICE, Constants.GOLD_RENT),
    PLATINUM(Constants.PLATINUM_PRICE, Constants.PLATINUM_RENT);

    private int value;
    private int rent;

    HotelType(int value, int rent) {
        this.value = value;
        this.rent = rent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
