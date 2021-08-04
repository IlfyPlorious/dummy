package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Override
    protected void onStart() {
        super.onStart();

        setConnectionStatus();
    }

    private void setConnectionStatus() {

    }

    private void register() {
        String weighUID = UUID.randomUUID().toString();
        String dbKilos;
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dbDate = dateFormat.format(date);

        dbKilos = kilos.getText().toString();
        int intKilos = Integer.parseInt(dbKilos.split("kg")[0]);
        Measure measurement = Measure.getInstance(intKilos, dbDate);

        if ( measurement != null )
            firebaseFirestore.collection("Weighs").document(weighUID).set(measurement);
        else Toast.makeText(this, "Incorrect Data", Toast.LENGTH_SHORT).show();

    }

    private void weigh() {

    }


}