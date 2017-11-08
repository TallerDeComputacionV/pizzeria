package com.tallerv.pizzeria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //IMPORTANTE! Para que aplique el toolbar

        //Esta parte hace que aparezca el hamburguer y lo asocie el Navigation con el Toolbar
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //Para que vaya al onNavigationItemSelected cuando se seleccione algun elemento
        navigationView.setNavigationItemSelectedListener(this);

        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza(getBaseContext(), "Muzzarela", R.drawable.muzzarella, 10));
        pizzaList.add(new Pizza(getBaseContext(), "Napolitana", R.drawable.napolitana, 15));
        pizzaList.add(new Pizza(getBaseContext(), "Jamon y queso", R.drawable.jamon, 20));
        pizzaList.add(new Pizza(getBaseContext(), "Calabresa", R.drawable.calabresa, 25));

        ListView pizzaLv = (ListView) findViewById(R.id.pizza_lv);
        pizzaLv.setAdapter(new PizzaAdapter(getBaseContext(), pizzaList));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //El OnClickListener para el FAB
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Ir hacia AddPizzaActivity", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Donde se infla el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //Le pasamos al inflater el layout y la instancia de menu que entro por parametro
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    //Donde se programama la respuesta ante la seleccion de algun elemento del toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        //Switch por id del elemento
        switch(item.getItemId()) {
            //Si es el id del carrito...
            case R.id.cart:
                //Esto es un placeholder, aca podrian iniciar otro intent y transicionar al Activity del carrito.
                Toast.makeText(getBaseContext(), "Ir al CartActivity", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    //Donde se programa la respuesta ante la seleccion de algun elemento del navigation
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Switch por id del elemento seleccionado
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "Compartir en Redes Intent", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Intent sendEmail = new Intent(Intent.ACTION_SENDTO);
                sendEmail.setType("text/plain");
                Intent.createChooser(sendEmail, "Encviar email");
                break;
            case R.id.close_session:
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                //Notar que se hace .edit() para obtener el editor
                // .clear() para limpiar todos los key value pairs almacenados en sharedpreferences.
                // .commit() para hacer efectivos los cambios.
                sharedPreferences.edit().clear().commit();
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                //finish() finaliza el activity actual, lo que significa que
                // cuando se presione backpress desde el proximo intent (en este caso el Login)
                // no se va a retornar a esta pantalla, no va a estar, entonces la app va a cerrar
                // (porque no le quedan pantallas para volver para atras).
                // Que justamente es lo que queremos que pase cuando se esta en el Login y se presiona backpress.
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Cierro el drawer ante la seleccion de cualquier item.
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}