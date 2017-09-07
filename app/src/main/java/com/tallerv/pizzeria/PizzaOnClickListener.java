package com.tallerv.pizzeria;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 *  OnClickListener para las vistas de articulos de Pizza
 */
public class PizzaOnClickListener implements View.OnClickListener{

    private Context context;
    private String texto;

    /**
     *
     * @param context necesario para inflar el ToastAlert
     * @param texto texto a visualizar en el alert luego del evento onClick
     */
    public PizzaOnClickListener(Context context, String texto) {
        this.context = context;
        this.texto = texto;
    }

    @Override
    //Comportamiento de respuesta ante el mensaje onCLick (evento)
    public void onClick(View view) {
        //Se "infla" un mensaje con el texto especificado
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }
}
