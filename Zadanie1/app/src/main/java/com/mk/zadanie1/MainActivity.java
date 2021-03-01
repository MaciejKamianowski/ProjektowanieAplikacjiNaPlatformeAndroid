package com.mk.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumberInput;
    private EditText secondNumberInput;
    //private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberInput = findViewById(R.id.first_number_edit_text);
        secondNumberInput = findViewById(R.id.second_number_edit_text);
        //resultTextView = findViewById(R.id.result_text_view);
    }

    public void addNumbers(View view) {
//        resultTextView.setText("Adding");
    }

    public void subNumbers(View view) {
//        resultTextView.setText("Subtraction");
    }

    public void mulNumbers(View view) {
//        resultTextView.setText("Multiplication");
    }

    public void divNumbers(View view) {
//        resultTextView.setText("Division");
    }
}