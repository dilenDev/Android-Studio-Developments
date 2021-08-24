package com.mobdev.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityIntent2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        setTitle("Second Activity"); // change title bar name

        Intent intent = getIntent(); // call intent
        //getting values by keyName
        int number1 = intent.getIntExtra("firstNumber",0);
        int number2 = intent.getIntExtra("secondNumber",0);

        TextView textViewNumbers = findViewById(R.id.text_view_numbers);
        textViewNumbers.setText("Number 1 :- " +number1+ "\n\nNumber 2 :- " +number2); //set retrieved numbers to text view

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSub);
        Button btnDivision = findViewById(R.id.btnDevide);
        Button btnMultiplication = findViewById(R.id.btnMultiplication);
        Button btnModulus = findViewById(R.id.btnModulus);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result); // push data to first activity by using "result key"

                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result); // push data to first activity by using "result key"

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 / number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result); // push data to first activity by using "result key"

                setResult(RESULT_OK, resultIntent); //RESULT_OK - there is a value
                Toast.makeText(ActivityIntent2.this, "Might not function properly", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 * number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result); // push data to first activity by using "result key"

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnModulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 % number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result); // push data to first activity by using "result key"

                setResult(RESULT_OK, resultIntent);
                Toast.makeText(ActivityIntent2.this, "Might not function properly", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Button backToFirst = findViewById(R.id.btnBackToFirst);
        backToFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent(ActivityIntent2.this,ActivityIntent.class);
                startActivity(backintent);
            }
        });
    }
}