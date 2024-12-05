package com.sukhee.eacourse.labs;


import com.sukhee.eacourse.labs.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application started.");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Game game = context.getBean("game-custom", Game.class);
        game.play();
        context.close();
        System.out.println("Application ended.");
    }
}