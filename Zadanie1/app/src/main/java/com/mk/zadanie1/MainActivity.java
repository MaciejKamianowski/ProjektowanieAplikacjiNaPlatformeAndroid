package com.mk.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumberInput;
    private EditText secondNumberInput;
    private TextView resultTextView;
    private double firstNumber;
    private double secondNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberInput = findViewById(R.id.first_number_edit_text);
        secondNumberInput = findViewById(R.id.second_number_edit_text);
        resultTextView = findViewById(R.id.result_text_view);
    }

    public void addNumbers(View view) {
//        resultTextView.setText("Adding");
        String firstValue = firstNumberInput
                .getText()
                .toString();
        String secondValue = secondNumberInput
                .getText()
                .toString();
        if (!firstValue.isEmpty() && !secondValue.isEmpty()){
            firstNumber = Double.parseDouble(firstValue);
            secondNumber = Double.parseDouble(secondValue);
            showResult(Double.toString(firstNumber + secondNumber));
        }
    }

    public void subNumbers(View view) {
//        resultTextView.setText("Subtraction");
        String firstValue = firstNumberInput
                .getText()
                .toString();
        String secondValue = secondNumberInput
                .getText()
                .toString();
        if (!firstValue.isEmpty() && !secondValue.isEmpty()){
            firstNumber = Double.parseDouble(firstValue);
            secondNumber = Double.parseDouble(secondValue);
            showResult(Double.toString(firstNumber - secondNumber));
        }
    }
    public void mulNumbers(View view) {
        String firstValue = firstNumberInput
                .getText()
                .toString();
        String secondValue = secondNumberInput
                .getText()
                .toString();
        if (!firstValue.isEmpty() && !secondValue.isEmpty()){
            firstNumber = Double.parseDouble(firstValue);
            secondNumber = Double.parseDouble(secondValue);
            showResult(Double.toString(firstNumber * secondNumber));
        }
//        resultTextView.setText("Multiplication");
    }

    public void divNumbers(View view) {
        String firstValue = firstNumberInput
                .getText()
                .toString();
        String secondValue = secondNumberInput
                .getText()
                .toString();
        if (!firstValue.isEmpty() && !secondValue.isEmpty()){
            firstNumber = Double.parseDouble(firstValue);
            secondNumber = Double.parseDouble(secondValue);

            if (secondNumber != 0){
                showResult(Double.toString(firstNumber /secondNumber));
            } else {
                showResult("Nie dziel przez zero !");
            }
        }
//        resultTextView.setText("Division");
    }

    public void showResult(String resultString){
        //wyświetl wynik w polu result_text_view
        if (!resultString.isEmpty()){
            resultTextView.setText(resultString);
        }
    }
}