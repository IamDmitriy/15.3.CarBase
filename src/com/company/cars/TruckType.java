package com.company.cars;

public class TruckType extends Car {

    public TruckType(String number, String model, String color) {
        super(number, model, color, CarTypeEnum.TRUCK);
    }
}