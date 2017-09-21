package com.tallerv.pizzeria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 *  OnClickListener para las vistas de articulos de Pizza
 */
public class PizzaOnClickListener implements View.OnClickListener{

    private Context context;
    private Pizza pizza;

    /**
     *
     * @param context necesario para inflar el ToastAlert
     * @param pizza la pizza con los datos a pasarle al Details en onClick
     */
    public PizzaOnClickListener(Context context, Pizza pizza) {
        this.context = context;
        this.pizza = pizza;
    }

    @Override
    //Actualizamos el metodo onClick para que redirija hacia el detalle de la pizza clickeada ademas del mensaje Toast.
    public void onClick(View view) {
        Toast.makeText(context, pizza.getNombre(), Toast.LENGTH_SHORT).show();
        //Se crea un intent especificando el contexto del que se parte y el .class del activity destino.
        Intent intent = new Intent(context, DetailsActivity.class);
        //Agregar extras es opcional, pero necesario para pasar informacion entre acitivties (este es un metodo, hay otros, ya los veremos).
        intent.putExtra("nombre", pizza.getNombre());
        intent.putExtra("fotoId", pizza.getFotoId());
        intent.putExtra("precio", pizza.getPrecio());
        //Con este metodo se inicia la transicion del intent y queda en el backstack el activity del que venimos para ser recuperado con la
        //accion backpress.
        context.startActivity(intent);
    }
}
