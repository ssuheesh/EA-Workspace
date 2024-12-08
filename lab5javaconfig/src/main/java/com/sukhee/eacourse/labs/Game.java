package com.sukhee.eacourse.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Game implements Cloneable {

    @Autowired
    private Vehicle vehicle;
    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Game() {}
    public void play(){
        vehicle.move();
    }
    public void destroy(){
        System.out.println("Destroying Game object...");
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public Game clone() {
        try {
            Game clone = (Game) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
