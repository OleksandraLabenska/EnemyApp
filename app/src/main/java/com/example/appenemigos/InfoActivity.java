package com.example.appenemigos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    TextView nombreTV;
    TextView edadTV;
    TextView descripcionTV;
    Button button2;

    String nombre;
    String edad;
    String descripcion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nombreTV = findViewById(R.id.nombreTV);
        edadTV = findViewById(R.id.edadTV);
        descripcionTV = findViewById(R.id.descripcionTV);
        button2 = findViewById(R.id.button2);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("Nombre");
        edad = intent.getStringExtra("Edad");
        descripcion = intent.getStringExtra("Descripción");

        nombreTV.setText(nombre);
        edadTV.setText(edad);
        descripcionTV.setText(descripcion);

    }

    public void clickButtonVolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
