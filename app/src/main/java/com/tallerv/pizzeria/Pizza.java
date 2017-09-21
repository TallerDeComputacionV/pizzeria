package com.tallerv.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.annotations.Expose;

/**
 * Clase modelo de la Pizza.
 */
public class Pizza {
    private transient Context context;
    private String nombre;
    private int fotoId;
    private double precio;


    //Para funcionar Gson necesita que el constructor sin parametros este definido en las
    //clases que serializa y deserializa ya que instancia un objeto con este constructor
    //y setea sus parametros con sus seters.
    public Pizza() {}

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

    /**
     * @return la vista representativa a la pizza
     */
    //Notar como ahora no necesitamos pasarle parametros al metodo (usa informacion propia de la instancia actual del objeto)
    //La informacion que usa tiene visibilidad en toda la clase (porque esta como atributo o como metodo de clase).
    public View parsePizza() {
        View pizzaItem = LayoutInflater.from(context).inflate(R.layout.pizza_item, null, false);
        //Ahora toda la informacion de la pizza la accedemos directo por los geters.
        ((TextView) pizzaItem.findViewById(R.id.nombre)).setText(getNombre());
        ((ImageView) pizzaItem.findViewById(R.id.foto)).setImageResource(getFotoId());
        ((TextView) pizzaItem.findViewById(R.id.precio)).setText(String.valueOf(getPrecio()));
        //Ahora el segundo parametro es la pizza en si (esta instancia, se referencia con la palabra this, que es la Pizza actual).
        pizzaItem.setOnClickListener(new PizzaOnClickListener(context, this));
        return pizzaItem;
    }
}

