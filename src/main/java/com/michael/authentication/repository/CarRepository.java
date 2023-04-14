package com.michael.authentication.repository;

import com.michael.authentication.model.Car;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ListCrudRepository<Car, String> {
}
