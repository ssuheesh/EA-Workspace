package com.sukhee.eacourse.labs;

import org.springframework.stereotype.Component;

//@Component
public class Bike implements Vehicle {

    @Override
    public void move() {
        System.out.println("Moving at 10mph.");
    }
}
