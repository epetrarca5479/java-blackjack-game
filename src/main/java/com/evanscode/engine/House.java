package com.evanscode.engine;

public class House {

    private double chips;

    // Constructor for a House
    public House(final double amount) {
        this.chips = amount;
    }

    // Method to subtract chips from house bank
    public void removeChips(final double amount) {
        this.chips = this.chips - amount;
    }

    // Method to add chips to house bank
    public void addChips(final double amount) {
        this.chips = this.chips + amount;
    }
}
