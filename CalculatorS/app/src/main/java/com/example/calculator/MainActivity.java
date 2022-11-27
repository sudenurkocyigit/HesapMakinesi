package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edidText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number =ed1.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                number += "1";
                break;
            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu4:
                number += "4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
            case R.id.bu0:
                number += "0";
                break;
            case R.id.buDot:
                number += ".";
                break;
            case R.id.buPlusMinus:
                number ="-" +number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buDivide: op = "/"; break;
            case R.id.buMultiply: op = "*"; break;
            case R.id.buPlus: op = "+"; break;
            case R.id.buMinus: op = "-"; break;
            case R.id.buSinus: op = "sin"; break;
            case R.id.buCosinus: op = "cos"; break;
            case R.id.buTanjant: op = "tan"; break;
            case R.id.buFaktoriyel: op = "!"; break;
        }


    }

    public void equalEvent(View view) {

        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "sin":
                result = Math.sin(Double.parseDouble(oldNumber));
                break;
            case "cos":
                result = Math.cos(Double.parseDouble(oldNumber));
                break;
            case "tan":
                result = Math.tan(Double.parseDouble(oldNumber));
                break;
            case "!":
                result = factorial(Integer.parseInt(oldNumber));
                break;

        }
        ed1.setText(result+"");

    }
    int factorial(int n)
    {
        return (n==1 || n==0) ? 1 : n*factorial(n-1);
    }

    public void acEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double no = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no +"");
        isNewOp = true;
    }
}