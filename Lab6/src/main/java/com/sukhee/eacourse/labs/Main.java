package com.sukhee.eacourse.labs;

import com.sukhee.eacourse.labs.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application started.");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Game game = context.getBean( "game", Game.class);
        game.play();
        context.close(); //to close I needed ClassPathXmlApplicationContext;
        System.out.println("Application ended.");
    }
}