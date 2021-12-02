package com.example.appenemigos;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListEnemigos {
    public ArrayList<Enemigo> enemigos;

    public  ListEnemigos(){
        enemigos = new ArrayList<>();
    }

    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return  json;
    }

    public ListEnemigos fromJson(String json){
        Gson gson = new Gson();
        ListEnemigos listEnemigos = gson.fromJson(json, ListEnemigos.class);
        return listEnemigos;
    }

}
