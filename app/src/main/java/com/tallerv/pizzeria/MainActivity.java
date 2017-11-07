package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generamos la lista de pizzas
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza(getBaseContext(), "Muzzarela", R.drawable.muzzarella, 10));
        pizzaList.add(new Pizza(getBaseContext(), "Napolitana", R.drawable.napolitana, 15));
        pizzaList.add(new Pizza(getBaseContext(), "Jamon y queso", R.drawable.jamon, 20));

        //Obtenemos el ListView de la vista
        ListView pizzaLv = (ListView) findViewById(R.id.pizza_lv);
        //Le asignamos el adapter pasandole el context (para asignarle OnClickListener a la vista)
        // y la lista de pizzas para que se los items se llenen con la informacion de ellas.
        pizzaLv.setAdapter(new PizzaAdapter(getBaseContext(), pizzaList));
    }
}