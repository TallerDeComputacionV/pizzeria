package com.tallerv.pizzeria;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity donde se va a realizar el Login.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText userEt;
    private EditText passwordEt;
    private Button enterBtn;
    private Context context;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        userEt = (EditText) findViewById(R.id.usuario_et);
        passwordEt = (EditText) findViewById(R.id.password_et);
        enterBtn = (Button) findViewById(R.id.enter_btn);

        //Obtengo una instancia de las SharedPreferences.
        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        //Consulto por los valores de las claves que me interesan.
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        //Si ambas existen significa que se hizo login anteriormente.
        if(!username.isEmpty() && !password.isEmpty()) {
            //Voy al menu de pizzas.
            gotoPizzaMenu();
        } else {
            //Defino el comportamiento para onClick del boton Ingresar.
            enterBtn .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isLoginSuccessful(userEt.getText().toString(), passwordEt.getText().toString())) {
                        //persistencia resuleta con SharedPreferences
                        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                        //Guardo asincronicamente las credenciales de logueo
                        sharedPreferences.edit()
                                .putString("username", userEt.getText().toString())
                                .putString("password", passwordEt.getText().toString())
                                .apply();
                        gotoPizzaMenu();
                    }
                }
            });
        }
    }

    /**
     * Redirige hacia la vista de menu de pizzas.
     */
    private void gotoPizzaMenu() {
        //Llamo al ciclo de cierre del LoginActivity.
        finish();
        //Redirijo hacia el MainActivity.
        startActivity(new Intent(context, MainActivity.class));
    }

    /**
     *
     * @return si los datos ingresados coinciden con las credenciales que definimos.
     */
    private boolean isLoginSuccessful(String username, String password) {
        return username.equals("alan") && password.equals("1234");
    }
}
