package com.michael.authentication.service;

import com.michael.authentication.exceptions.CarNotFoundException;
import com.michael.authentication.model.Car;
import com.michael.authentication.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarById(String id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent()){
            return car.get();
        }

        throw new CarNotFoundException(String.format("Car with id %s is not available.", id));
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(Car car){
        carRepository.save(car);
    }
}
