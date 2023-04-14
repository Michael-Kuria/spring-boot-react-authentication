package com.michael.authentication.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="cars")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String model;
    private int cost;

    public Car(String model, int cost){
        this.model = model;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
