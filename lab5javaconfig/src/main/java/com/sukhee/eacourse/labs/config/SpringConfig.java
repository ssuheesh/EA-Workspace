package com.sukhee.eacourse.labs.config;

import com.sukhee.eacourse.labs.Bike;
import com.sukhee.eacourse.labs.Car;
import com.sukhee.eacourse.labs.Game;
import com.sukhee.eacourse.labs.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class SpringConfig {

    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy(value = true)
    public Vehicle vehicle(){
        return new Bike();
    }

    @Bean(name = "game-custom", destroyMethod = "destroy")
//    @Lazy(value = true)
    public Game game(){
        return new Game();
    }
}
