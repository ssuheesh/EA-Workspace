package com.sukhee.eacourse.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
//@Component("game")
public class Game {
//    @Autowired
    private Car car;
//    @Autowired
    private Bike bike;
//    public Game() {
//        System.out.println("Game constructor 1");
//    }
    public Game(Car car, Bike bike) {
        System.out.println("Game Constructor 2");
        this.car = car; this.bike = bike;
    }
//    public void setCar(Car car) {
//        this.car = car;
//    }
//    public void setBike(Bike bike) {
//        this.bike = bike;
//    }
    public void play(){
        car.move();
        bike.move();
    }

    public void destroy(){
        System.out.println("Destroying Game object...");
    }
}
