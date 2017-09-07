package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = LayoutInflater.from(getBaseContext());
        View viewMuzzarella = layoutInflater.inflate(R.layout.muzzarella_item, null, false);
        View viewNapolitana = layoutInflater.inflate(R.layout.napolitana_item, null, false);
        View viewJamon = layoutInflater.inflate(R.layout.jamon_item, null, false);


        LinearLayout pizzaLl = (LinearLayout) findViewById(R.id.pizza_container);
        //TODO: Seria util poder generar las vistas de las pizzas programaticamente. Ya que de esa
        //TODO: manera no tendria que hacer la vista xml a mano por cada pizza que se agregue en un futuro,
        //TODO: podria construirlas inicializando objetos (mucho mas simple) y ademas podria tener un template
        //TODO: de pizza.xml (!) donde centralizar el diseño del layout para la pizza en uno solo, en vez de
        //TODO: tener que repetir los cambios de diseño que se vayan haciendo en cada uno de esos lauyout (absolutamente no escalable y extremadamente doloroso).
        //TODO: ¿Como seria una implementacion de esta situacion con objetos? ¿Voy a necesitar modelar otras entidades? ¿Cuales?
        pizzaLl.addView(viewMuzzarella);
        pizzaLl.addView(viewNapolitana);
        pizzaLl.addView(viewJamon);


        //Asi queda extrayendo la logica de las clases anonimas a una no anonima (con nombre).
        viewMuzzarella.setOnClickListener(new PizzaOnClickListener(getBaseContext(), "Muzzarella"));
        viewNapolitana.setOnClickListener(new PizzaOnClickListener(getBaseContext(), "Napolitana"));
        viewJamon.setOnClickListener(new PizzaOnClickListener(getBaseContext(), "Jamon y Muzzarella"));
    }
}