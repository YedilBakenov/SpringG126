package kz.bitlab.G126FirstProject.controller;

import kz.bitlab.G126FirstProject.model.Student;
import kz.bitlab.G126FirstProject.repository.CityRepository;
import kz.bitlab.G126FirstProject.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "/")
    public String getIndex(Model model){
        model.addAttribute("list", studentService.getAllStudents());
        return "main2";
    }

    @GetMapping("/add-student")
    public String addStudentPage(Student st, Model model){
        model.addAttribute("cities", cityRepository.findAll());
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student){
        studentService.addStudent(student);
        return "redirect:/student/";
    }
//
//    @PostMapping("/add-car-v2")
//    public String addCar2(@RequestParam String model,
//                          @RequestParam Double volume,
//                          @RequestParam Double price,
//                          @RequestParam int year){
//        Car car = new Car();
//        car.setModel(model);
//        car.setPrice(price);
//        car.setVolume(volume);
//        car.setYear(year);
//
//        carService.addCar(car);
//
//        return "redirect:/";
//    }
//
    @GetMapping("/student-details/{id}")
    public String getCarDetails(@PathVariable int id,
                                Model model){
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("st", studentService.getStudentById(id));
        return "student-details";
    }

    @PostMapping("/update-student")
    public String updateStudent(Student st){
        studentService.updateStudent(st);
        return "redirect:/student/";
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@RequestParam int id){
        studentService.deleteStudentById(id);
        return  "redirect:/student/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search,
                         Model model){
        model.addAttribute("list", studentService.searchByWord(search));
        return "main2";
    }
}
