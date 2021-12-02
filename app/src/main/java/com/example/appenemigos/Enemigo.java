package com.example.appenemigos;

public class Enemigo {
    public String nombre;
    public String edad;
    public String descripcion;

    public Enemigo (String nombre, String edad, String descripcion){
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
