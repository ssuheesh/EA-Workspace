package com.sukhee.eacourse.labs;


import com.sukhee.eacourse.labs.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application started.");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Game game = context.getBean("game-custom", Game.class);
        game.play();
        System.out.println(game);
        System.out.println(game.getVehicle());
        Game game2 = context.getBean("game-custom", Game.class);
        System.out.println(game2);
        System.out.println(game2.getVehicle());
        game2.play();
//        Game game3 = game.clone();
//        System.out.println(game3);
//        System.out.println(game3.getVehicle());
        context.close();
        System.out.println("Application ended.");
    }
}