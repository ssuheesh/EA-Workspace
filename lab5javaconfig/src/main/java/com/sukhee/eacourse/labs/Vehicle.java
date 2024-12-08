package com.sukhee.eacourse.labs;

public abstract class Vehicle {
    boolean canRead = true;
    String engineState = "STOP";
    public abstract void move();
    public String getEngineState() {
        if(canRead) {
            return engineState;
        } else {
            return null;
        }
    }

    public void setEngineState(String engineState) {
        canRead = false;
        synchronized(Vehicle.class) {
            this.engineState = engineState;
        }
        canRead = true;
    }
}
