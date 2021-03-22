package com.parcial.codigotransapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListaVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vehiculo);
    }

    public void goToRegistroVehiculo(View view) {
        Intent intent = new Intent(this,RegistroVehiculoActivity.class);
        startActivity(intent);
    }
}