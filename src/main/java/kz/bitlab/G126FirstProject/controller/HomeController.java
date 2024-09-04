package kz.bitlab.G126FirstProject.controller;

import kz.bitlab.G126FirstProject.db.DBManager;
import kz.bitlab.G126FirstProject.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    // @WebServlet(value = "/")
    // protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    // req.setAttribute("list", DBConnection.getAllCars());
    // req.getRequestDispatcher("/main.jsp").forward(req, res);}
    @GetMapping(value = "/")
    public String getIndex(Model model){
        model.addAttribute("list", DBManager.getCars());
        return "main";
    }

    @PostMapping("/add-car")
    public String addCar(Car car){
        DBManager.addCar(car);
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

        DBManager.addCar(car);

        return "redirect:/";
    }

    @GetMapping("/car-details/{id}")
    public String getCarDetails(@PathVariable int id,
                                Model model){
        model.addAttribute("car", DBManager.getCarById(id));
        return "car-details";
    }

    @PostMapping("/update-car")
    public String updateCar(Car car){
        DBManager.updateCar(car);
        return "redirect:/";
    }

    @PostMapping("/delete-car")
    public String deleteCar(@RequestParam int id){
        DBManager.deleteCarById(id);
        return "redirect:/";
    }

}
