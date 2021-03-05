package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Signing extends AppCompatActivity {

    String nombre2, contrasena2;

    EditText username;
    EditText password;

    HashMap<String, String> accounts = new HashMap<String, String>();
    HashMap<String, Double> dinero = new HashMap<String, Double>();


    Button signIn;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing);

        // Getting information from the main Axtivity
        Intent intent = getIntent();
        String usuarioGuardado = intent.getStringExtra(MainActivity.EXTRA_USERNAME);
        String contrasenaGuardado = intent.getStringExtra(MainActivity.EXTRA_PASSWORD);
        double moneyGuardado = intent.getDoubleExtra(MainActivity.EXTRA_MONEY, 0);

        accounts.put(usuarioGuardado, contrasenaGuardado);
        dinero.put(usuarioGuardado, moneyGuardado);



        TextView textView = (TextView) findViewById(R.id.ejemplo);

        textView.setText(usuarioGuardado);


        signIn = (Button) findViewById(R.id.sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Error aqui
                username = (EditText) findViewById(R.id.usuarioNumber2);
                password = (EditText) findViewById(R.id.contrasenaNumber2);
                nombre2 = username.getText().toString();
                contrasena2 = password.getText().toString();

                String comprobar = accounts.get(nombre2);

                //Conditional

                if (contrasena2.equals(comprobar)){
                    getAccount();
                } else {
                    showToast("Wrong Password");
                }

                showToast(nombre2);

                //End

            }
        });

        signUp = (Button) findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSigningUp();
            }
        });


    }

    public void showToast(String palabra){ Toast.makeText(this, palabra, Toast.LENGTH_SHORT).show(); }

    public void openSigningUp(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void getAccount(){
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
    }

}