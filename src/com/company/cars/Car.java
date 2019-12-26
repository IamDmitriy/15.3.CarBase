package com.company.cars;

import java.util.Objects;

public class Car {
    protected String number;
    protected String model;
    protected String color;
    protected CarTypeEnum carType;

    public Car(String number, String model, String color, CarTypeEnum carType) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.carType = carType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + ", " + model + ", " + color;
    }

    public CarTypeEnum getCarType() {
        return carType;
    }
}