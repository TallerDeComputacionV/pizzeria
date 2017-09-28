package com.tallerv.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View viewMuzza = new Pizza(getBaseContext(), "Muzzarela", R.drawable.muzzarella, 10).parsePizza();
        View viewNapo = new Pizza(getBaseContext(), "Napolitana", R.drawable.napolitana, 15).parsePizza();
        View viewJamon = new Pizza(getBaseContext(), "Jamon y queso", R.drawable.jamon, 20).parsePizza();

        LinearLayout pizzaLl = (LinearLayout) findViewById(R.id.pizza_container);
        pizzaLl.addView(viewMuzza);
        pizzaLl.addView(viewNapo);
        pizzaLl.addView(viewJamon);
    }
}