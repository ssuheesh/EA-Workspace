package com.sukhee.eacourse.lab1;

import com.sukhee.eacourse.lab1.entity.Car;
import com.sukhee.eacourse.lab1.repository.CarRepository;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Tesla 1", "Version 1", 2020, 100000);
        Car car2 = new Car("Tesla 2", "Version 2", 2024, 0);
        Car car3 = new Car("Lambo", "V8", 2024, 0);
        CarRepository carRepository = CarRepository.getInstance();
        carRepository.create(car1);
        carRepository.create(car2);
        carRepository.create(car3);
        carRepository.findAll().forEach(System.out::println);
        carRepository.findById(3);
        carRepository.delete(car1);
        carRepository.delete(car3);
        carRepository.findAll().forEach(System.out::println);
        car2.setMake("Version 3");
        car2.setMileage(20000);
        carRepository.update(car2);
        carRepository.findAll().forEach(System.out::println);
        carRepository.destroy();
    }
}