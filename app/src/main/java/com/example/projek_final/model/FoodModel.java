package com.example.projek_final.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FoodModel {

    @SerializedName("foodId")
    private String foodId;
    @SerializedName("label")
    private String label;
    @SerializedName("category")
    private String category;
    @SerializedName("image")
    private String image;
    @SerializedName("nutrients")
    private Nutrients nutrients;

    // Getters and Setters

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public Nutrients getNutrients() { return nutrients; }
    public void setNutrients(Nutrients nutrients) { this.nutrients = nutrients; }
}
