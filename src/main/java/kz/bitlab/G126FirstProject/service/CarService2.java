package kz.bitlab.G126FirstProject.service;

import kz.bitlab.G126FirstProject.model.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Qualifier("second")
public class CarService2 {

    static int id = 5;
    public static ArrayList<Car>cars = new ArrayList<>();

    static {
        cars.add(new Car(1, 2022, 5.5, 180000, "JAGUAR"));
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
