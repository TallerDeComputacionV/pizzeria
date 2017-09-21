package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflamos el layout adecuado
        setContentView(R.layout.activity_details);

        //Obtenemos los argumentos que pasamos como extras en al intent.
        Bundle extras = getIntent().getExtras();

        //Recobramos cada uno de los valores con el metodo adecuado al tipo de dato.
        String nombre = extras.getString("nombre");
        //No necesitamos recuperarlos en el mismo orden al ingresado, eso es indistinto.
        double precio = extras.getDouble("precio");
        int fotoID = extras.getInt("fotoId");

        //Usamos la informacion recabada para popular de informacion los elementos visuales.
        ImageView fotoIv = (ImageView) findViewById(R.id.foto);
        fotoIv.setImageResource(fotoID);
        TextView nombreTv = (TextView) findViewById(R.id.nombre);
        nombreTv.setText(nombre);
        TextView precioTv = (TextView) findViewById(R.id.precio);
        precioTv.setText(Double.toString(precio));
    }
}


