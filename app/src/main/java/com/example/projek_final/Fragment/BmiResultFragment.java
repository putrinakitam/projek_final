package com.example.projek_final.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projek_final.R;

public class BmiResultFragment extends Fragment {
    TextView mbmidisplay,magedisplay,mweightdisplay,mheightdisplay,mbmicategory,mgender;
    Button mgotomain;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    String cateogory;
    float intbmi;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout mbackground;
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_result, container, false);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Html.fromHtml("<font color=\"#FFFFFF\">Result</font>"));
        }

        mbmidisplay = view.findViewById(R.id.bmidisplay);
        mbmicategory = view.findViewById(R.id.bmicategorydispaly);
        mimageview = view.findViewById(R.id.imageview);
        mgotomain = view.findViewById(R.id.gotomain);
        mbackground = view.findViewById(R.id.contentlayout);

        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireFragmentManager().popBackStack();
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            height = bundle.getString("height");
            weight = bundle.getString("weight");

            // Menghitung BMI
            float intheight = Float.parseFloat(height) / 100;
            float intweight = Float.parseFloat(weight);
            intbmi = intweight / (intheight * intheight);

            // Menampilkan hasil BMI
            mbmidisplay.setText(String.valueOf(intbmi));

            // Menentukan kategori BMI dan menyesuaikan tampilan
            setBMICategory(intbmi);
        }

        return view;
    }

    // Method untuk menentukan kategori BMI dan menyesuaikan tampilan
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