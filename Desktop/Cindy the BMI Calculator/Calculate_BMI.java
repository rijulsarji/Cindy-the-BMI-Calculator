package com.example.bmiapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculate_BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate__b_m_i);

        Button bttn = (Button) findViewById(R.id.calculate);

        bttn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        EditText height = (EditText) findViewById(R.id.height);
                        String Height_TBC = height.getText().toString();
                        int Height = Integer.parseInt(Height_TBC);

                        EditText weight = (EditText) findViewById(R.id.weight);
                        String Weight_TBC = weight.getText().toString();
                        int Weight = Integer.parseInt(Weight_TBC);

                        double Result = Weight/((Height * Height)*0.0001);
                        String out = String.format("%.2f",Result);

                        TextView Output = (TextView) findViewById(R.id.output);
                        Output.setText(out + " kg/m\u00B2");
                        Output.setTypeface(Typeface.DEFAULT_BOLD);

                        if (Result <= 18) {
                        Output.setTextColor(Color.parseColor("#FFD700"));
                        }

                        else if (Result>18 && Result <=24.9) {
                        Output.setTextColor(Color.parseColor("#9ACD32"));
                        }

                        else if (Result>24.9 && Result <=29.9) {
                            Output.setTextColor(Color.parseColor("#FF8C00"));
                        }

                        else if (Result >29.9) {
                            Output.setTextColor(Color.RED);
                        }
                    }




                }
        );

    }

    public void OnMainMenu (View v1){
        super.onBackPressed();
    }
}