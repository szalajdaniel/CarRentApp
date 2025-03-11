package com.example.carrent.Enum;

public enum CarCattegory {

    SUV("Suv"),
    SEDAN("Sedan"),
    HATCHBACK("Hatchback");
private final String carCattegory;
    CarCattegory(String carCattegory) {
        this.carCattegory = carCattegory;
    }
    public String getCattegory() {
        return carCattegory;
    }
}