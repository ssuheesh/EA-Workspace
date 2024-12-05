package com.sukhee.eacourse.labs.config;

import com.sukhee.eacourse.labs.Bike;
import com.sukhee.eacourse.labs.Game;
import com.sukhee.eacourse.labs.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Vehicle vehicle(){
        return new Bike();
    }
    @Bean(name = "game-custom", destroyMethod = "destroy")
    public Game game(){
        return new Game(vehicle());
    }
}
