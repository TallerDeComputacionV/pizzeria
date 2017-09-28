package com.tallerv.pizzeria;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

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
    public void onClick(View view) {
        Toast.makeText(context, pizza.getNombre(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, DetailsActivity.class);
        String pizzaSerializada = new Gson().toJson(pizza);
        intent.putExtra("pizza", pizzaSerializada);
        context.startActivity(intent);
    }
}
