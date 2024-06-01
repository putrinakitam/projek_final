package com.example.projek_final.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projek_final.DetailFoodActivity;
import com.example.projek_final.R;
import com.example.projek_final.model.FoodModel;
import com.example.projek_final.model.Nutrients;
import com.example.projek_final.responses.FoodResponses;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<FoodModel> foodModels;
    private List<FoodResponses.FoodHint> foodHints;
    Context context;

    public FoodAdapter(List<FoodModel> foodModels, List<FoodResponses.FoodHint> foodHints, Context context) {
        this.foodModels = foodModels;
        this.foodHints = foodHints;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foods, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodModel foodModel = foodModels.get(position);
        holder.bind(foodModel);

        holder.btnDetail.setOnClickListener(v -> {
            String foodId = foodModel.getFoodId();
            FoodModel selectedFoodModel = null;

            for (FoodResponses.FoodHint hint : foodHints) {
                if (hint.getFood().getFoodId().equals(foodId)) {
                    selectedFoodModel = hint.getFood();
                    break;
                }
            }

            if (selectedFoodModel != null) {
                String label = selectedFoodModel.getLabel();
                String category = selectedFoodModel.getCategory();
                String image = selectedFoodModel.getImage();
                Nutrients nutrients = selectedFoodModel.getNutrients();

                Intent intent = new Intent(context, DetailFoodActivity.class);
                intent.putExtra("label", label);
                intent.putExtra("category", category);
                intent.putExtra("image", image);
                intent.putExtra("nutrients", nutrients); // Pass the nutrients object
                context.startActivity(intent);
            } else {
                Toast.makeText(context, "Failed to find food data", Toast.LENGTH_SHORT).show();
            }
        });

        if (context == null) {
            Log.e("FoodAdapter", "Context is null in onBindViewHolder");
        }
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_foto;
        TextView tv_label;
        TextView tv_category;
        LinearLayout btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.IV_food);
            tv_label = itemView.findViewById(R.id.TV_food_name);
            tv_category = itemView.findViewById(R.id.TV_food_category);
            btnDetail = itemView.findViewById(R.id.btnDetail);
        }

        public void bind(FoodModel foodModel) {
            Picasso.get().load(foodModel.getImage()).into(iv_foto);
            tv_label.setText(foodModel.getLabel());
            tv_category.setText(foodModel.getCategory());
        }
    }
}
