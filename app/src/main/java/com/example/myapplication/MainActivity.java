package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_USERNAME = "com.example.application.example.EXTRA_USERNAME";
    public static final String EXTRA_PASSWORD = "com.example.application.example.EXTRA_PASSWORD";
    public static final String EXTRA_MONEY = "com.example.application.example.EXTRA_MONEY";

    //Esto puede ser borrado
    //public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String TEXT = "text";


    String nombre1, contrasena1;
    double money1;

    private EditText username;
    private EditText password;
    private EditText moneyInput;



    private Button signUp;
    private Button signIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        moneyInput = (EditText) findViewById(R.id.money);

        signUp = (Button) findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //nombre1.setText(username.getText().toString());
                nombre1 = username.getText().toString();
                contrasena1 = password.getText().toString();

                //saveData();
                money1 = Double.parseDouble(moneyInput.getText().toString());
                showToast();

                //This is going to pass variables that will be saved
            }
        });

        //loadData();

        signIn = (Button) findViewById(R.id.sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSigning();
            }
        });

}

    public void showToast(){
        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
    }

    public void openSigning() {

        EditText nombre = (EditText) findViewById(R.id.username);
        String pasarNombre = nombre.getText().toString();

        EditText password = (EditText) findViewById(R.id.password);
        String pasarPassword = password.getText().toString();

        EditText money = (EditText) findViewById(R.id.money);
        Double pasarMoney = Double.parseDouble(money.getText().toString());

        Intent intent = new Intent(this, Signing.class);
        intent.putExtra(EXTRA_USERNAME, pasarNombre);
        intent.putExtra(EXTRA_PASSWORD, pasarPassword);
        intent.putExtra(EXTRA_MONEY, pasarMoney);

        startActivity(intent);
    }

    //This is to save data
    /*
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, username.getText().toString());
        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

    }

    //Load data

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        nombre1 = sharedPreferences.getString(TEXT, "");
    }

     */
}