package com.company;

import com.company.cars.Car;
import com.company.cars.CarType;
import com.company.cars.CarTypeEnum;
import com.company.cars.TruckType;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Set<Car> carSet = new HashSet<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        addCars(); //TODO лучше сделать что то вроде импорт карс

        while (true) {
            System.out.println("Введите информацию об автомобиле: \"номер, модель, цвет, тип автомобиля\", " +
                    "для выхода введите \"end\"");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            parseCar(input);
        }

        printSetCars();

    }

    private static void printSetCars() {

        System.out.println("Легковые автомобили:");
        for (Car car : carSet) {
            if (car.getCarType().equals(CarTypeEnum.CAR)) {
                System.out.println(car);
            }
        }
        System.out.println();

        System.out.println("Грузовые автомобили:");
        for (Car car : carSet) {
            if (car.getCarType().equals(CarTypeEnum.TRUCK)) {
                System.out.println(car);
            }
        }
    }

    private static void parseCar(String str) {
        String[] inputArray = str.split(",");
        if (inputArray.length != 4) {
            System.out.println("Введите данные в указанном формате!");
            return;
        }

        String number = inputArray[0].trim();
        String model = inputArray[1].trim();
        String color = inputArray[2].trim();
        String carTypeString = inputArray[3].trim().toLowerCase();
        CarTypeEnum carType;

        if (carTypeString.contains("груз")) {
            carType = CarTypeEnum.TRUCK;
        } else {
            carType = CarTypeEnum.CAR;
        }

        Car curCar = new Car(number, model, color, carType);

        checkAdd(curCar);
    }

    private static void addCars() {
        Car[] carArray = new Car[]{
                new CarType("А192АА199", "ВАЗ 2105", "белый"),
                new CarType("А192АА199", "ВАЗ 2106", "синий"),
                new TruckType("B788AB99", "Камаз 120", "красный"),
                new TruckType("B1111119", "Камаз 120", "красный"),

        };

        for (Car car : carArray) {
            checkAdd(car);
        }
    }

    private static void checkAdd(Car car) {
        boolean isAdded = carSet.add(car);
        if (isAdded) {
            System.out.println("Автомобиль успешно добавлен в список");
        } else {
            if (carSet.contains(car)) {
                System.out.println("Автомобиль уже есть в списке!");
            } else {
                System.out.println("Что-то пошло не так");
            }
        }
    }

}