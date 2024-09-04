package kz.bitlab.G126FirstProject.db;

import kz.bitlab.G126FirstProject.model.Car;

import java.util.ArrayList;

public class DBManager {

    static int id = 5;
    public static ArrayList<Car>cars = new ArrayList<>();

    static {
        cars.add(new Car(1, 2022, 3.5, 80000, "BMW X5M"));
        cars.add(new Car(2, 2024, 4.0, 160000, "BMW X5MK"));
        cars.add(new Car(3, 2024, 4.0, 120000, "BMW X7"));
        cars.add(new Car(4, 2024, 3.0, 110000, "BMW X6M"));
    }

    public static ArrayList<Car> getCars(){
        return cars;
    }

    public static void addCar(Car car){
        car.setId(id);
        id++;
        cars.add(car);
    }

    public static Car getCarById(int id) {
        return cars.stream().filter(s -> s.getId()==id).findFirst().orElseThrow();
    }

    public static void updateCar(Car car) {
        for(Car c: cars){
            if(c.getId()==car.getId()){
                c.setYear(car.getYear());
                c.setVolume(car.getVolume());
                c.setModel(car.getModel());
                c.setPrice(car.getPrice());
            }
        }

    }

    public static void deleteCarById(int id) {
        cars.removeIf(s->s.getId()==id);
    }
}
