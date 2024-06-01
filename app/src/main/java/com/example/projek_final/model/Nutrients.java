package com.example.projek_final.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Nutrients implements Serializable {
    @SerializedName("ENERC_KCAL")
    private double enercKcal;
    @SerializedName("PROCNT")
    private double protein;
    @SerializedName("FAT")
    private double fat;
    @SerializedName("CHOCDF")
    private double carbohydrate;
    @SerializedName("FIBTG")
    private double fiber;

    // Getters and setters

    public double getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(double enercKcal) {
        this.enercKcal = enercKcal;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }
}
