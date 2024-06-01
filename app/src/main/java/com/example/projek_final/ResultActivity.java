package com.example.projek_final;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView mbmidisplay, mbmicategory;
    Button mgotomain;
    ImageView mimageview;
    String height;
    String weight;
    float intbmi;
    RelativeLayout mbackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Html.fromHtml("<font color=\"#FFFFFF\">Result</font>"));
        }

        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mimageview = findViewById(R.id.imageview);
        mgotomain = findViewById(R.id.gotomain);
        mbackground = findViewById(R.id.contentlayout);

        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            height = intent.getStringExtra("height");
            weight = intent.getStringExtra("weight");

            // Menghitung BMI
            float intheight = Float.parseFloat(height) / 100;
            float intweight = Float.parseFloat(weight);
            intbmi = intweight / (intheight * intheight);

            // Menampilkan hasil BMI
            mbmidisplay.setText(String.valueOf(intbmi));

            // Menentukan kategori BMI dan menyesuaikan tampilan
            setBMICategory(intbmi);
        }
    }
    private void setBMICategory(float bmi) {
        if (bmi < 16) {
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.baseline_clear_24);
        } else if (bmi < 16.9) {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(getResources().getColor(R.color.satu));
            mimageview.setImageResource(R.drawable.baseline_warning_24);
        } else if (bmi < 18.4) {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(getResources().getColor(R.color.satu));
            mimageview.setImageResource(R.drawable.baseline_warning_24);
        } else if (bmi < 24.9) {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.baseline_check_24);
        } else if (bmi < 29.9) {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(getResources().getColor(R.color.satu));
            mimageview.setImageResource(R.drawable.baseline_warning_24);
        } else if (bmi < 34.9) {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(getResources().getColor(R.color.satu));
            mimageview.setImageResource(R.drawable.baseline_warning_24);
        } else {
            mbmicategory.setText("Obese Class II");
            mbackground.setBackgroundColor(getResources().getColor(R.color.satu));
            mimageview.setImageResource(R.drawable.baseline_clear_24);
        }
    }

}