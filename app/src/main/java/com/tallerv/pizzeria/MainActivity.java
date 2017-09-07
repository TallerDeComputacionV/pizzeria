package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = LayoutInflater.from(getBaseContext()); //Objeto que "infla" layouts
        View viewMuzzarella = layoutInflater.inflate(R.layout.muzzarella_item, null, false); //"inflado" de layouts, devuelve un objeto del tipo View
        View viewNapolitana = layoutInflater.inflate(R.layout.napolitana_item, null, false);
        View viewJamon = layoutInflater.inflate(R.layout.jamon_item, null, false);

        //Desde los activities al hacer findViewById se busca el layout con el id especificado en el que se uso para setContentView
        LinearLayout pizzaLl = (LinearLayout) findViewById(R.id.pizza_container);
        pizzaLl.addView(viewMuzzarella); //Se agrega el objeto View pasado como parametro a la lista de elementos del LinearLayout
        pizzaLl.addView(viewNapolitana);
        pizzaLl.addView(viewJamon);

        //Se setea el onClickListener para el objeto View.
        //El OnClickListener define comportamiento para el evento onClick que se efectue sobre la vista (View).
        //Ejemplo definiendo el OnClickListener como clase anonima (inner class)
        viewMuzzarella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Muzzarella", Toast.LENGTH_SHORT).show();
            }
        });
        viewNapolitana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Napolitana", Toast.LENGTH_SHORT).show();
            }
        });
        viewJamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Jamon y Muzzarella", Toast.LENGTH_SHORT).show();
            }
        });

        //TODO: Aca podemos ver que los OnClickListeners definidos son muy similares (indicio de repeticion de logica). Lo unico que cambia es el
        //TODO: texto del mensaje que muestran. ¿Como podriamos extraer esa logica para reutilizarla?
    }
}