package com.michael.authentication.controller;

import com.michael.authentication.model.Car;
import com.michael.authentication.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id){
        return carService.getCarById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }
}
