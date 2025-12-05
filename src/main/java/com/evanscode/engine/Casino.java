package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** A class to represent a Casino */
public class Casino {

    /** FIELDS */
    private double chips;
    private final List<Table> tables;

    /** Constructor for a house (A Casino) */
    public Casino(final double amount) {
        this.chips = amount;
        this.tables = new ArrayList<>();
    }

    /** Method to deduct chips from a casino's balance */
    public void removeChips(final double amount) {
        this.chips = this.chips - amount;
    }

    /** Method to add chips to a casino's balance */
    public void addChips(final double amount) {
        this.chips = this.chips + amount;
    }

    /** Method to get a table within a casino */
    public Table getTable(final int tableID) {
        return this.tables.get(tableID);
    }

    /** Method to set up a table within a casino */
    public void setTable(final Table table) {
        this.tables.add(table);
    }
}
