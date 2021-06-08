package com.parcial.codigotransapp.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.services.persona.PersonaServiceImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaVehiculo extends AppCompatActivity {

    @BindView(R.id.listViewPersonas)
    ListView listViewPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vehiculo);
        ButterKnife.bind(this);
        PersonaServiceImpl personaService = new PersonaServiceImpl(this);
        personaService.getPersona(listViewPersonas);
    }

    public void goToRegistroVehiculo(View view) {
        Intent intent = new Intent(ListaVehiculo.this,RegistroVehiculoActivity.class);
        startActivity(intent);
    }
}