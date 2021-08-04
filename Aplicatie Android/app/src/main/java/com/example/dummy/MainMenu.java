package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    private Button weighButton, registerButton;
    private TextView kilos, connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        weighButton = findViewById(R.id.weighButton);
        registerButton = findViewById(R.id.registerButton);
        kilos = findViewById(R.id.kilos);
        connection = findViewById(R.id.connection);


    }



}