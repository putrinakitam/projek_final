package com.example.projek_final.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projek_final.R;
import com.example.projek_final.ResultActivity;


public class BmiFragment extends Fragment {

    TextView mcurrentheight;
    TextView mcurrentweight,mcurrentage;
    ImageView mincrementage,mdecrementage,mincrementweight,mdecrementweight;
    SeekBar mseekbarforheight;
    Button mcalculatebmi;
    RelativeLayout mmale,mfemale;

    int intweight=55;
    int intage=22;
    int currentprogress;
    String mintprogress="170";
    String typerofuser="0";
    String weight2="55";
    String age2="22";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        mcurrentage = view.findViewById(R.id.currentage);
        mcurrentweight = view.findViewById(R.id.currentweight);
        mincrementage = view.findViewById(R.id.incrementage);
        mdecrementage = view.findViewById(R.id.decrementage);
        mincrementweight = view.findViewById(R.id.incrementweight);
        mdecrementweight = view.findViewById(R.id.decrementweight);
        mseekbarforheight = view.findViewById(R.id.seekbarforheight);
        mcurrentheight = view.findViewById(R.id.currentheight);
        mmale = view.findViewById(R.id.male);
        mfemale = view.findViewById(R.id.female);
        mcalculatebmi = view.findViewById(R.id.calculatebmi);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.male_female_focus));
                mfemale.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.male_female_notfocus));
                typerofuser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.male_female_focus));
                mmale.setBackground(ContextCompat.getDrawable(requireContext(),R.drawable.male_female_notfocus));
                typerofuser="Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typerofuser.equals("0")) {
                    Toast.makeText(getActivity(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (mintprogress.equals("0")) {
                    Toast.makeText(getActivity(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                } else if (intage == 0 || intage < 0) {
                    Toast.makeText(getActivity(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (intweight == 0 || intweight < 0) {
                    Toast.makeText(getActivity(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("gender", typerofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", String.valueOf(intweight));
                    intent.putExtra("age", String.valueOf(intage));

                    startActivity(intent);
                }
            }
        });


        return view;
    }

}