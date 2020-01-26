package org.cartrawler.quiz;

import org.cartrawler.quiz.consts.FuelPolicy;

import java.util.Objects;

/**
 * Created by Archil Matchavariani on 19/01/2020
 */
public class Car {

    private String supplier;
    private String description;
    private String sspCode;
    private double rentalCost;
    private FuelPolicy fuelPolicy;


    public Car() {
    }

    public Car(String supplier, String description, String sspCode, double rentalCost, FuelPolicy fuelPolicy) {
        this.supplier = supplier;
        this.description = description;
        this.sspCode = sspCode;
        this.rentalCost = rentalCost;
        this.fuelPolicy = fuelPolicy;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSspCode() {
        return sspCode;
    }

    public void setSspCode(String sspCode) {
        this.sspCode = sspCode;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public FuelPolicy getFuelPolicy() {
        return fuelPolicy;
    }

    public void setFuelPolicy(FuelPolicy fuelPolicy) {
        this.fuelPolicy = fuelPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(supplier, car.supplier) &&
                Objects.equals(description, car.description) &&
                Objects.equals(sspCode, car.sspCode) &&
                fuelPolicy == car.fuelPolicy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplier, description, sspCode, fuelPolicy);
    }

    @Override
    public String toString() {
        return "supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", sspCode='" + sspCode + '\'' +
                ", rentalCost=" + rentalCost +
                ", fuelPolicy=" + fuelPolicy +
                '}';
    }
}
