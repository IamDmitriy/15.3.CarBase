package com.company.cars;

public class CarType extends Car{

    public CarType(String number, String model, String color) {
        super(number, model, color, CarTypeEnum.CAR);
    }
}
