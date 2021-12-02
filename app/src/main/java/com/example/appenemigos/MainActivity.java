package com.example.appenemigos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText nombreET;
    EditText edadET;
    EditText descripcionET;
    Button button1;
    ListView list;
    ListEnemigos listEnemigos;

    String nombre;
    String edad;
    String descripcion;

    Adaptor adaptor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreET = findViewById(R.id.nombreET);
        edadET = findViewById(R.id.edadET);
        descripcionET = findViewById(R.id.descripcionET);
        button1 = findViewById(R.id.button1);
        list = findViewById(R.id.list);

        sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        String json = sharedPreferences.getString("Enemigos", "");

        if(!json.isEmpty()){
            listEnemigos = new ListEnemigos();
            listEnemigos = listEnemigos.fromJson(json);
        }else{
            listEnemigos = new ListEnemigos();
        }

        adaptor = new Adaptor(this, R.layout.enemigo, listEnemigos.enemigos);
        list.setAdapter(adaptor);

        list.setOnItemClickListener(this);
    }

    public void clickButton(View view){

        nombre = nombreET.getText().toString();
        edad = edadET.getText().toString();
        descripcion = descripcionET.getText().toString();
        //int edad1 = Integer.parseInt(edad);

        if(nombre.equals("")){
            Toast.makeText(this, "Introduzca el nombre!", Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(edad) <= 0 || Integer.parseInt(edad) >= 150 || edadET.getText().toString().isEmpty()) {
            Toast.makeText(this, "La edad debe estar entre 0 y 150!", Toast.LENGTH_SHORT).show();
        }else{
            Enemigo newEnemigo = new Enemigo((nombreET.getText().toString()), edadET.getText().toString(), descripcionET.getText().toString());

            listEnemigos.enemigos.add(newEnemigo);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Enemigos", listEnemigos.toJson());
            editor.apply();

            adaptor.notifyDataSetChanged();


        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtra("Nombre", listEnemigos.enemigos.get(position).nombre);
            intent.putExtra("Edad", listEnemigos.enemigos.get(position).edad);
            intent.putExtra("Descripción", listEnemigos.enemigos.get(position).descripcion);
            startActivity(intent);
            finish();
        }


}