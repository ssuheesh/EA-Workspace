package com.sukhee.eacourse.labs.config;

import com.sukhee.eacourse.labs.Bike;
import com.sukhee.eacourse.labs.Car;
import com.sukhee.eacourse.labs.Game;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.sukhee.eacourse.labs") // Equivalent to <context:component-scan />
public class Config {
    @Bean(name = "car1")
    public Car car1() {
        return new Car(); // Replace with CarFactory if needed.
    }

    @Bean(name = "car2")
    public Car car2() {
        return new Car(); // Replace with CarFactory if needed.
    }

    @Bean(name = "bike")
    public Bike bike() {
        return new Bike();
    }

    @Bean(name = "game", destroyMethod = "destroy")
    public Game game(@Qualifier("car1") Car car, Bike bike) {
        //constructor
        Game game = new Game(car, bike);
        //setter
//         game.setCar(car);
//         game.setBike(bike);
        return game;
    }
}
