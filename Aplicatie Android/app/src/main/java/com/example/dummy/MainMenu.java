package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

public class MainMenu extends AppCompatActivity {

    private Button weighButton, registerButton;
    private TextView kilos, connection;
    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        weighButton = findViewById(R.id.weighButton);
        registerButton = findViewById(R.id.registerButton);
        kilos = findViewById(R.id.kilos);
        connection = findViewById(R.id.connection);
        firebaseFirestore = FirebaseFirestore.getInstance();

        weighButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weigh();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    
    private void register() {
        String weigh = UUID.randomUUID().toString();
        String dbKilos;
        dbKilos = kilos.getText().toString();
        firebaseFirestore.collection("Weighs").document(weigh).set(dbKilos);

    }

    private void weigh() {
    }


}