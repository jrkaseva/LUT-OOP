package com.example.nelilaskin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Author: Joakim Kaseva
 * Last modified: 15.3.2023
 */
public class MainActivity extends AppCompatActivity {

    /**
    * Max value is Double.MAX_VALUE "somewhere around 1.7*10^308"
    * https://stackoverflow.com/questions/16146219/java-double-max-value
    */
    private EditText number1;
    private EditText number2;

    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.firstNumber);
        number2 = findViewById(R.id.secondNumber);

        res = findViewById(R.id.result);
    }

    /**
     * Sets the result with the sum of two numbers
     * @param view view
     */
    public void calculateSum(View view){
        System.out.println("Calculating sum");

        try{
            double a = Double.valueOf(number1.getText().toString());
            double b = Double.valueOf(number2.getText().toString());

            res.setText(String.format("%.0f", a + b));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            res.setText("Virhe syötteessä");
        }
    }

    /**
     * Sets the result with the difference of two numbers
     * @param view view
     */
    public void calculateDiff(View view){
        System.out.println("Calculating difference");
        try{
            double a = Double.valueOf(number1.getText().toString());
            double b = Double.valueOf(number2.getText().toString());

            res.setText(String.format("%.0f", a - b));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            res.setText("Virhe syötteessä");
        }
    }

    /**
     * Sets the result with the product of two numbers
     * @param view view
     */
    public void calculateMult(View view){
        System.out.println("Calculating product");
        try{
            double a = Double.valueOf(number1.getText().toString());
            double b = Double.valueOf(number2.getText().toString());

            res.setText(String.format("%.0f", a * b));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            res.setText("Virhe syötteessä");
        }
    }

    /**
     * Sets the quotient of two given numbers
     * @param view view
     */
    public void calculateDiv(View view){
        System.out.println("Calculating quotient");
        try{
            double a = Double.valueOf(number1.getText().toString());
            double b = Double.valueOf(number2.getText().toString());

            if (b == 0) res.setText("Virhe: Nollalla ei voi jakaa");
            else res.setText(String.format("%.5f", a / b));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            res.setText("Virhe syötteessä");
        }
    }
}