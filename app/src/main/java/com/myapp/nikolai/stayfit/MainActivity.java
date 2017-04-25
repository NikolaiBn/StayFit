package com.myapp.nikolai.stayfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_calc = (Button) findViewById(R.id.button_calc);
        final EditText field_age = (EditText) findViewById(R.id.field_age);
        final EditText field_weight = (EditText) findViewById(R.id.field_weight);
        final EditText field_height = (EditText) findViewById(R.id.field_height);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);
        final TextView log_msg= (TextView) findViewById(R.id.log_box);        //final RadioButton radio_male =(RadioButton) findViewById(R.id.radio_male);
        final RadioButton radiomale =(RadioButton) findViewById(R.id.radioBtnMale);
        final RadioGroup radioGenderGroup = (RadioGroup) findViewById(R.id.radioGroup);

        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double weight;
                double height;
                double bmi;
                double age;

                String msg="";

                weight = Double.parseDouble(field_weight.getText().toString());
                height = Double.parseDouble(field_height.getText().toString());
                age = Double.parseDouble(field_age.getText().toString());

                if(field_height.getText().toString().equals("") || field_weight.getText().toString().equals("") ){

                    Toast.makeText(getApplicationContext(), "Oops! No valid values!", Toast.LENGTH_LONG);
                }else {
                    bmi = height * height;
                    bmi = weight / bmi;

                   if (age >15){
                       bmi=bmi*1.025;
                   }else if (age > 15 && age < 25){

                   }else if (age > 25 && age < 40) {
                       bmi=bmi*0.990;
                   }else if (age > 40 && age <60) {
                       bmi=bmi*0.975;
                   }else if(age > 60){
                       bmi=bmi*0.95;
                   }


                    if (bmi < 15) {
                        msg = "Very Severely underweight >:C";
                    } else if (bmi > 15 && bmi < 16) {
                        msg = "Severely Underweight :C";
                    } else if (bmi > 16 && bmi < 18.5) {
                        msg = "Underweight :(";
                    }else if (bmi > 18.5 && bmi < 25) {
                        msg = "Healthy weight :D";
                    }else if (bmi > 25 && bmi < 30) {
                        msg = "Overweight :/";
                    }else if (bmi > 30 && bmi < 35) {
                        msg = "Obese class I :O";
                    }else if (bmi > 35 && bmi < 40) {
                        msg = "Obese class II :'(";
                    } else if (bmi > 40) {
                        msg = "Obese class II :'(";
                    }

                    String bmi_f = String.format("%.2f",bmi);

                    view_result.setText(String.valueOf(bmi_f));

                   // view_msg.setText(String.valueOf(selectedId));
                    view_msg.setText(msg);

                    boolean a =radiomale.isSelected();
                    String s=radiomale.getText().toString();
                   log_msg.setText(String.valueOf(a));
                  //  log_msg.setText(s);

                }
            }
        });
    }

}
