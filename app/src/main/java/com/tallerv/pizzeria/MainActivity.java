package com.tallerv.pizzeria;

import android.app.ProgressDialog;
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

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PizzeriaApiClient.init(getApplicationContext());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Debe ser final porque es usado en otro contexto (Thread) asyncronicamente.
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Pizzeria",
                "Obteniendo el menu...", true, false); //Instancio el progress dialog
        PizzeriaApiClient.getPizzas(new OnSuccessCallback() {
            @Override
            public void execute(Object body) {
                //Lo que se debe hacer con la respuesta del servidor
                ListView pizzaLv = (ListView) findViewById(R.id.pizza_lv); //El listview
                //Le asigno el adapter, al cual le paso el contexto y la lista de pizzas que vino
                pizzaLv.setAdapter(new PizzaAdapter(getBaseContext(), (List<Pizza>) body));
                //Saco el Progress Dialog de la pantalla
                progressDialog.dismiss();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Ir hacia AddPizzaActivity", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.cart:
                Toast.makeText(getBaseContext(), "Ir al CartActivity", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
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
                sharedPreferences.edit().clear().commit();
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}