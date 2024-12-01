package com.sukhee.eacourse.lab2.entity;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id@GeneratedValue
    private long id;

    private String model;
    private String make;
    private int year;
    private int mileage;
    @OneToOne(mappedBy = "car", fetch = FetchType.EAGER)
    private Person owner;
    @OneToOne
    @JoinColumn(name="driver_person_id")
    private Person driver;

    protected Car(){}
    public Car(String model, String make, int year, int mileage) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
    }
    public Car(String model, String make, int year, int mileage, Person owner) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.owner = owner;
    }

    public Car(String model, String make, int year, int mileage, Person owner, Person driver) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.owner = owner;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", \n\t\towner=" + owner +
                ", \n\t\tdriver=" + driver +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
    public Person getDriver() {
        return driver;
    }
    public void setDriver(Person driver) {
        this.driver = driver;
    }
}
