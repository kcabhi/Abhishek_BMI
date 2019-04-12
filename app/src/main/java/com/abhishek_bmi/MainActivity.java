package com.abhishek_bmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   EditText height,weight ,result ;
   Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        calc = findViewById(R.id.calc);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double h, w, bmi;
                h= (Double.parseDouble(height.getText().toString()))/100;

                w = Double.parseDouble(weight.getText().toString());

                bmi = w/(h*h);
                bmi = Math.round(bmi*100)/100.0D;

                result.setText(Double.toString(bmi));

                if (bmi<18.5){
                    Toast.makeText(MainActivity.this, "Underweight",Toast.LENGTH_LONG).show();
                }
                else if(bmi>18.5 && bmi<24.9){
                    Toast.makeText(MainActivity.this, "Normal Weight",Toast.LENGTH_LONG).show();

                }
                else if(bmi>25 && bmi<29.9){
                    Toast.makeText(MainActivity.this, "Overweight",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Obesity",Toast.LENGTH_LONG).show();

                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(calc.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);


            }
        });

    }
}
