package kz.bitlab.G126FirstProject.controller;

import kz.bitlab.G126FirstProject.component.HomeComponent;
import kz.bitlab.G126FirstProject.model.Car;
import kz.bitlab.G126FirstProject.service.CarService;
import kz.bitlab.G126FirstProject.service.CarService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    @Qualifier("second")
    private CarService2 carService;

    @Autowired
    private HomeComponent component;

    @GetMapping(value = "/")
    public String getIndex(Model model){
        model.addAttribute("list", carService.getCars());
        component.getInfo();
        return "main";
    }

    @PostMapping("/add-car")
    public String addCar(Car car){
        carService.addCar(car);
        return "redirect:/";
    }

    @GetMapping("/add-car")
    public String addCarPage(){
        return "add-car";
    }

    @PostMapping("/add-car-v2")
    public String addCar2(@RequestParam String model,
                          @RequestParam Double volume,
                          @RequestParam Double price,
                          @RequestParam int year){
        Car car = new Car();
        car.setModel(model);
        car.setPrice(price);
        car.setVolume(volume);
        car.setYear(year);

        carService.addCar(car);

        return "redirect:/";
    }

    @GetMapping("/car-details/{id}")
    public String getCarDetails(@PathVariable int id,
                                Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "car-details";
    }

    @PostMapping("/update-car")
    public String updateCar(Car car){
        carService.updateCar(car);
        return "redirect:/";
    }

    @PostMapping("/delete-car")
    public String deleteCar(@RequestParam int id){
        carService.deleteCarById(id);
        return "redirect:/";
    }

}
