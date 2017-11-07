package com.tallerv.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Clase modelo de la Pizza.
 */
public class Pizza {
    private transient Context context;
    private String nombre;
    private int fotoId;
    private double precio;

    /**
     * Modelo de Pizza con los minimos parametros necesarios para ser definida (en nuestro modelo de negocios).
     * @param nombre nombre
     * @param fotoId id de recurso para la foto
     * @param precio costo actual
     */
    public Pizza(String nombre, int fotoId, double precio) {
        this.nombre = nombre;
        this.fotoId = fotoId;
        this.precio = precio;
    }

    /**
     * Modelo de Pizza agregando Context para instanciar View representativa.
     * @param context contexto
     * @param nombre nombre
     * @param fotoId id de recurso para la foto
     * @param precio costo actual
     */
    public Pizza(Context context, String nombre, int fotoId, double precio) {
        this(nombre, fotoId, precio);
        this.context = context;
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

    public Context getContext() {
        return context;
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

    public void setContext(Context context) {
        this.context = context;
    }
}

