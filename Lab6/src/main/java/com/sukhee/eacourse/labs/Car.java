package com.sukhee.eacourse.labs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Moving at 50mph.");
    }
}
