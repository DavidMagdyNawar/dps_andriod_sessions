package com.dps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cast our views
        final TextView helloTextView = findViewById(R.id.hello);
        final EditText nameEditText = findViewById(R.id.nameEditText);
        Button clickMeButton = findViewById(R.id.clickMeButton);

        //on click the button " click me "
        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the edit text is empty
                if(nameEditText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                // if it's not empty,
                else{
                    helloTextView.setText("Hello " + nameEditText.getText().toString()+"!");
                }
            }
        });

    }
}