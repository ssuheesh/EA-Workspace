package com.sukhee.eacourse.lab2;


import com.sukhee.eacourse.lab2.entity.Car;
import com.sukhee.eacourse.lab2.entity.Person;
import com.sukhee.eacourse.lab2.repository.CarRepository;
import com.sukhee.eacourse.lab2.repository.EmfSingleton;
import com.sukhee.eacourse.lab2.repository.PersonRepository;

public class Main {
    public static void main(String[] args) {
        try(EmfSingleton emfSingleton = EmfSingleton.getInstance()) {
            Car car1 = new Car("Tesla 1", "Version 1", 2020, 100000);
            Car car2 = new Car("Tesla 2", "Version 2", 2024, 0);
            Car car3 = new Car("Lambo", "V8", 2024, 0);
            CarRepository carRepository = new CarRepository(emfSingleton);
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

            PersonRepository personRepository = new PersonRepository(emfSingleton);

            Person person2 = new Person("Driver");
            personRepository.create(person2);
//            carRepository.create(car1);
            Car car4 = new Car("Tesla 1", "Version 1 New", 2020, 100000);
            car4.setDriver(person2);
            carRepository.create(car4);
            Person person1 = new Person("Sukhbat", car4);
            personRepository.create(person1);

            personRepository.findAll().forEach(System.out::println);
//            personRepository.delete(person1);
            carRepository.findAll().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}