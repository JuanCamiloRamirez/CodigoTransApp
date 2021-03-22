package com.parcial.codigotransapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registro(View view) {
        Intent intent = new Intent(this,SingupActivity.class);
        startActivity(intent);
    }

    public void acceder(View view) {
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);

    }
}