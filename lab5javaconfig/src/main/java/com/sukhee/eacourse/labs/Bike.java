package com.sukhee.eacourse.labs;

public class Bike extends Vehicle {

    @Override
    public void move() {
        if(!engineState.equals("START")){
            engineState = "START";
        } else {
            System.out.println("Already moving...");
            return;
        }
        System.out.println("Moving at 10mph.");
    }
}
