package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        //La pizza serializada ingresada por extra.
        String pizzaSerializada = extras.getString("pizza");
        //Deserializo la pizza a su representacion de objeto java.
        Pizza pizza = new Gson().fromJson(pizzaSerializada, Pizza.class);

        //Utilizo los datos de la pizza desde su representacion objeto para
        //rellenar su representacion visual.
        ImageView fotoIv = (ImageView) findViewById(R.id.foto);
        fotoIv.setImageResource(pizza.getFotoId());
        TextView nombreTv = (TextView) findViewById(R.id.nombre);
        nombreTv.setText(pizza.getNombre());
        TextView precioTv = (TextView) findViewById(R.id.precio);
        precioTv.setText(Double.toString(pizza.getPrecio()));
    }
}


