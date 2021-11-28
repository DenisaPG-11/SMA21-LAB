package com.upt.cti.smartwallet;

import java.io.Serializable;

public class Payment implements Serializable {
    public String timestamp;
    private double cost;
    private String name;
    private String type;


    public Payment() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }
}
