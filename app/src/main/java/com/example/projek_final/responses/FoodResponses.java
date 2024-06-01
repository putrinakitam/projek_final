package com.example.projek_final.responses;

import com.example.projek_final.model.FoodModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FoodResponses {
    @SerializedName("hints")
    private List<FoodHint> hints;

    public List<FoodHint> getHints() {
        return hints;
    }

    public void setHints(List<FoodHint> hints) {
        this.hints = hints;
    }

    public static class FoodHint {
        @SerializedName("food")
        private FoodModel food;

        public FoodModel getFood() {
            return food;
        }

        public void setFood(FoodModel food) {
            this.food = food;
        }
    }
}
