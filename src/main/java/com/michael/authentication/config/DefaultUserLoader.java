package com.michael.authentication.config;


import com.michael.authentication.model.Car;
import com.michael.authentication.model.User;
import com.michael.authentication.model.UserRole;
import com.michael.authentication.service.CarService;
import com.michael.authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserLoader {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final CarService carService;

    public DefaultUserLoader(UserService userService, PasswordEncoder passwordEncoder, CarService carService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.carService = carService;
    }

    @Bean
    public CommandLineRunner loadDefaultUser(){

        return args -> {
            User user = new User("root@gmail.com",
                    "root",
                    "admin",
                    passwordEncoder.encode("password"),
                    UserRole.ADMIN,
                    true,true,true,true);

            /**
             * To avoid adding the root user everytime the app runs
             */
            if(userService.userCount() < 1){
                userService.saveUser(user);
            }
            System.out.println(String.format("User %s details", userService.loadUserByUsername("root@gmail.com").getUsername()));


            Car car1 = new Car("Mercedes", 1000);
            Car car2 = new Car("Lambogini", 2000);

            carService.addCar(car1);
            carService.addCar(car2);
        };

    }

}
