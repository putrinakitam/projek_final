package com.example.projek_final;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projek_final.model.Nutrients;
import com.squareup.picasso.Picasso;

public class DetailFoodActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvname;
    private TextView tvcategory;
    private TextView tvcalories;
    private TextView tvprotein;
    private TextView tvfat;
    private TextView tvkarb;
    private TextView tvfiber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        // Inisialisasi komponen UI
        imageView = findViewById(R.id.iv_food_image);
        tvname = findViewById(R.id.tv_food_name);
        tvcategory = findViewById(R.id.tv_food_category);
        tvcalories = findViewById(R.id.tv_enerc_kcal);
        tvprotein = findViewById(R.id.tv_pro_cnt);
        tvfat = findViewById(R.id.tv_fat);
        tvkarb = findViewById(R.id.tv_chocdf);
        tvfiber = findViewById(R.id.tv_fibtg);

        // Mengambil data yang dikirimkan melalui Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String label = bundle.getString("label");
            String category = bundle.getString("category");
            String image = bundle.getString("image");
            Nutrients nutrients = (Nutrients) bundle.getSerializable("nutrients");

            if (nutrients != null) {
                // Menampilkan data pada UI
                Picasso.get().load(image).into(imageView);
                tvname.setText(label);
                tvcategory.setText(category);
                tvcalories.setText(String.valueOf(nutrients.getEnercKcal()));
                tvprotein.setText(String.valueOf(nutrients.getProtein()));
                tvfat.setText(String.valueOf(nutrients.getFat()));
                tvkarb.setText(String.valueOf(nutrients.getCarbohydrate()));
                tvfiber.setText(String.valueOf(nutrients.getFiber()));
            } else {
                // Handle case where nutrients is null
                tvcalories.setText("N/A");
                tvprotein.setText("N/A");
                tvfat.setText("N/A");
                tvkarb.setText("N/A");
                tvfiber.setText("N/A");
            }
        }
    }
}
