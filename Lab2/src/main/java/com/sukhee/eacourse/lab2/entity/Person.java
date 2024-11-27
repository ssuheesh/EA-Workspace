package com.sukhee.eacourse.lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="person")
public class Person {
    @Id@GeneratedValue
    private Long id;
    private String name;
    @OneToOne //DEFAULT is PERSIST
    @JoinColumn(name = "car_id")
    private Car car;

    public Person() {}
    public Person(String name) {
        this.name = name;
    }
    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", \n\tcar=" + car +
                '}';
    }
}
