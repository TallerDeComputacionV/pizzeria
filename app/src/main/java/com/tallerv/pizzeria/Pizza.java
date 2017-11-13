package com.tallerv.pizzeria;

/**
 * Clase modelo de la Pizza.
 */
public class Pizza {
    private int id;
    private String nombre;
    private int fotoId;
    private double precio;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public int getFotoId() {
        return fotoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFotoId(int fotoId) {
        this.fotoId = fotoId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

