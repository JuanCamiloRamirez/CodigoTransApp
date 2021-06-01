package com.parcial.codigotransapp.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parcial.codigotransapp.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void listarVehiculo(View view) {
        Intent intent = new Intent(this,ListaVehiculo.class);
        startActivity(intent);
    }

    public void goToCodigoTransito(View view){
        Intent intent = new Intent(this, CodigoTransitoFragment.class);
        startActivity(intent);
    }
}