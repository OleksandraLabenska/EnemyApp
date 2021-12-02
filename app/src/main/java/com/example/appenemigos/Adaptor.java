package com.example.appenemigos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adaptor extends ArrayAdapter {

    Context context;
    int enemigoLayout;
    ArrayList<Enemigo> enemigos;

    public Adaptor(@NonNull Context context, int resource, @NonNull ArrayList<Enemigo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.enemigoLayout = resource;
        enemigos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(enemigoLayout, parent, false);
        }

        TextView enemigoTV = convertView.findViewById(R.id.enemigoTV);

        enemigoTV.setText(enemigos.get(position).nombre);

        return convertView;
    }
}
