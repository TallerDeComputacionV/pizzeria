package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//MainActivity de nuestra App, es la primera que mostraremos. Hereda de AppCompatActivity funcionalidad base.
public class MainActivity extends AppCompatActivity {
    //Se sobreescribe el metodo definido por la clase padre (AppCompatActivity)
    @Override
    //El metodo onCreate se llama en el proceso de inicializacion del Activity.
    //Usualmente es donde se "infla" el layout que representa su interfaz grafica.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Para extender el comportamiento ya implementado en el onCreate de AppCompatActivity
        setContentView(R.layout.activity_main); //"Infla" el layout principal del activity

        //TODO: Este es el MainActivity mas basico que se puede tener.
    }
}