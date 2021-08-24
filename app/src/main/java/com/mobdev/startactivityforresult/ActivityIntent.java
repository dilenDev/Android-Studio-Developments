package com.mobdev.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityIntent extends AppCompatActivity {

    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;
    private EditText mEditTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        mEditTextNumber1 = findViewById(R.id.editTextNumber1);
        mEditTextNumber2 = findViewById(R.id.editTextNumber2);
        mEditTextResult  = findViewById(R.id.editTextResult);

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate the user input - prevent from app crashing
                if(mEditTextNumber1.getText().toString().equals("") || mEditTextNumber2.getText().toString().equals("")){
                    Toast.makeText(ActivityIntent.this, "Please Enter Numbers", Toast.LENGTH_SHORT).show();
                }else {

                    //get numbers from edit text as integer values
                    int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                    int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                    //open second activity
                    Intent intent = new Intent(ActivityIntent.this,ActivityIntent2.class);

                    //pass data to second activity

                    //putExtra - data passing keyword
                    intent.putExtra("firstNumber",number1); //key (name) - identify the number later on  // number1 - passed value
                    intent.putExtra("secondNumber",number2);
                    //ToDo: key should be constance - do not hard code the key

                    //calling the the startActivityForResult - (get something back from second activity)
                    startActivityForResult(intent,1); // requestCode - identify the request later on
                    //ToDo: should create constance for request
                }
            }
        });
        //back to menu button
        Button btnBackToMenu = findViewById(R.id.backToMenu);
        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenu = new Intent(ActivityIntent.this,MainActivity.class);
                startActivity(toMenu);
            }
        });
    }
    /* set retrieved results */
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result",0);
                mEditTextResult.setText("Result :- "+ result);
            }
            //press back button instead of clicking the operator button
            //TODO: not functioning
            if (requestCode == RESULT_CANCELED){
                mEditTextResult.setText("Nothing Selected");
            }
        }
    }
}