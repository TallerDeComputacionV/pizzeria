package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancio una nueva Pizza con los datos que cada una especifica y uso un metodo que me
        //permite generar una vista de pizza en funcion de los datos de una que le pase por parametro.
        View viewMuzza = parsePizza(new Pizza("Muzzarela", R.drawable.muzzarella, 10));
        View viewNapo = parsePizza(new Pizza("Napolitana", R.drawable.napolitana, 15));
        View viewJamon = parsePizza(new Pizza("Jamon y queso", R.drawable.jamon, 20));

        //TODO: El metodo parsePizza esta bueno, pero no se si es el mejor lugar para ponerlo aca...
        //TODO: Pensemos, el Activity, ¿deberia ser responsable de saber "inflar" un objeto Pizza a su representacion como View?
        //TODO: De solo formularse la pregunta ya suena que esto es algo que estaria mejor modelado en otro lado...

        LinearLayout pizzaLl = (LinearLayout) findViewById(R.id.pizza_container);
        pizzaLl.addView(viewMuzza);
        pizzaLl.addView(viewNapo);
        pizzaLl.addView(viewJamon);
    }


    /**
     * Recibe la representacion de una pizza y devuelve la vista con sus datos.
     * @param pizza la pizza a representar en la vista
     * @return la vista con los datos de la pizza
     */
    private View parsePizza(Pizza pizza) {
        //Se "infla" el template del item de pizza.
        View pizzaItem = LayoutInflater.from(getBaseContext()).inflate(R.layout.pizza_item, null, false);
        //Se castea lo devuelto por findViewById al objeto visual que sabemos que es realmente y lo configuramos con la data de la pizza.
        ((TextView) pizzaItem.findViewById(R.id.nombre)).setText(pizza.getNombre()); //Para el TextView nos interesa setear el texto
        ((ImageView) pizzaItem.findViewById(R.id.foto)).setImageResource(pizza.getFotoId()); //Para el ImageView el resourceId de la imagen (resourceId porque tenemos guardada la imagen en el proyecto, sino esto seria diferente)
        ((TextView) pizzaItem.findViewById(R.id.precio)).setText(String.valueOf(pizza.getPrecio()));
        //Le agregamos el listener de OnClick a la vista.
        pizzaItem.setOnClickListener(new PizzaOnClickListener(getBaseContext(), pizza.getNombre()));
        return pizzaItem;
    }
}