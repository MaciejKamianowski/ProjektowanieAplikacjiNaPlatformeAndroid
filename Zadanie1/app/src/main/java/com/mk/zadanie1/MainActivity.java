package com.mk.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

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

    private double dodawanieLiczb(double first, double second){
        return first + second;
    }
    public void addNumbers(View view) {
        String firstValue = firstNumberInput
                .getText()
                .toString();
        String secondValue = secondNumberInput
                .getText()
                .toString();
        if (!firstValue.isEmpty() && !secondValue.isEmpty()){
            firstNumber = Double.parseDouble(firstValue);
            secondNumber = Double.parseDouble(secondValue);
            showResult(Double.toString(dodawanieLiczb(firstNumber, secondNumber)));
        }
    }

    private double odejmowanieLiczb(double first, double second){
        return first-second;
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
            showResult(Double.toString(odejmowanieLiczb(firstNumber, secondNumber)));
        }
    }
    private double mnozenieLiczb(double first, double second){
        return first * second;
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
            showResult(Double.toString(mnozenieLiczb(firstNumber, secondNumber)));
        }
    }
    private double dzielenieLiczb(double first, double second){
        return first / second;
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
                showResult(Double.toString(dzielenieLiczb(firstNumber, secondNumber)));
            } else {
                showResult("Nie dziel przez zero !");
            }
        }
    }

    public void showResult(String resultString){
        //wyświetl wynik w polu result_text_view
        if (!resultString.isEmpty()){
            resultTextView.setText(resultString);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Date currentTime = Calendar.getInstance().getTime();
        Log.d("onPause", "onPause method called at " + currentTime.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Date currentTime = Calendar.getInstance().getTime();
        Log.d("onResume", "onResume method called at " + currentTime.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Date currentTime = Calendar.getInstance().getTime();
        Log.d("onDestroy", "onDestroy method called at " + currentTime.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Date currentTime = Calendar.getInstance().getTime();
        Log.d("onStop", "onStop method called at " + currentTime.toString());

        // ERROR MESSAGES
        //Log.e();

        // WARNING MESSAGES
        //Log.w();

        // INFORMATION MESSAGES
        //Log.i(TAG, "onStop: ");

        // DEBUG MESSAGES
        //Log.d();

        // VERBOSE MESSAGES
        //Log.v();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Date currentTime = Calendar.getInstance().getTime();
        Log.d("onStart", "onStart method called at " + currentTime.toString());
    }
}
