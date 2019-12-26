package com.company.cars;

public enum CarTypeEnum {
    TRUCK("Грузовик"),
    CAR("Легковой автомобиль");

    String title;

    CarTypeEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "\"" + title + "\"";
    }
}