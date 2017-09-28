package com.tallerv.pizzeria;


import android.content.Context;
import android.content.Intent;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        context = this;
        userEt = (EditText) findViewById(R.id.usuario_et);
        passwordEt = (EditText) findViewById(R.id.password_et);
        enterBtn = (Button) findViewById(R.id.enter_btn);

        enterBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLoginSuccessful()) {
                    startActivity(new Intent(context, MainActivity.class));
                }
            }
        });
    }

    /**
     *
     * @return si los datos ingresados coinciden con las credenciales que definimos.
     */
    private boolean isLoginSuccessful() {
        return userEt.getText().toString().equals("alan") && passwordEt.getText().toString().equals("1234");
    }
}
