package com.sukhee.eacourse.labs;

import org.springframework.beans.factory.FactoryBean;


public class CarFactory implements FactoryBean<Car> {
    static Car car = null;

    @Override
    public Car getObject() throws Exception {
        if(car == null) {
            this.car = new Car();
        }
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }
}
