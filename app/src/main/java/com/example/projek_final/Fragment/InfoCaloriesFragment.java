package com.example.projek_final.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projek_final.R;
import com.example.projek_final.adapter.FoodAdapter;
import com.example.projek_final.api.ApiConfig;
import com.example.projek_final.api.ApiService;
import com.example.projek_final.model.FoodModel;
import com.example.projek_final.responses.FoodResponses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoCaloriesFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    ApiService apiService;
    FoodAdapter foodAdapter;
    TextView errorTextView;
    Button retryButton;
    ArrayList<FoodModel> foodModel = new ArrayList<>();
    ArrayList<FoodResponses.FoodHint> foodHints = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info_calories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_food);
        context = getContext();
        errorTextView = view.findViewById(R.id.errorTextView);
        retryButton = view.findViewById(R.id.retryButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        foodAdapter = new FoodAdapter(foodModel, foodHints, context);
        recyclerView.setAdapter(foodAdapter);

        apiService = ApiConfig.getClient().create(ApiService.class);
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        Call<FoodResponses> call = apiService.getFood();
        call.enqueue(new Callback<FoodResponses>() {
            @Override
            public void onResponse(Call<FoodResponses> call, Response<FoodResponses> response) {
                if (response.isSuccessful()) {
                    FoodResponses data = response.body();
                    if (data != null && data.getHints() != null && !data.getHints().isEmpty()) {
                        for (FoodResponses.FoodHint hint : data.getHints()) {
                            foodModel.add(hint.getFood());
                            foodHints.add(hint);
                        }
                        foodAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponses> call, Throwable t) {
                Log.e("InfoCaloriesFragment", "Failed to fetch data", t);
                Toast.makeText(context, "Failed to fetch data: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
