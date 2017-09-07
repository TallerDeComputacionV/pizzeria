package com.tallerv.pizzeria;

/**
 * Clase modelo de la Pizza.
 */
public class Pizza {
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

