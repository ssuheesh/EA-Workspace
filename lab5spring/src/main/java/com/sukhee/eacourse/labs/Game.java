package com.sukhee.eacourse.labs;

public class Game {
    private Vehicle vehicle;
    public Game() {}
    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void play(){
        vehicle.move();
    }

    public void destroy(){
        System.out.println("Destroying Game object...");
    }
}
