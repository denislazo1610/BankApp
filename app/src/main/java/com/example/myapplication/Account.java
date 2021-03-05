package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Account extends AppCompatActivity {

    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        signOut = (Button) findViewById(R.id.Log_out);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoingBack();
            }
        });
    }

    public void GoingBack(){
        Intent intent = new Intent(this, Signing.class);
        startActivity(intent);
    }
}