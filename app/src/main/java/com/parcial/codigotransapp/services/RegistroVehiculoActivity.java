package com.parcial.codigotransapp.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.dao.PersonaDTO;
import com.parcial.codigotransapp.model.Persona;
import com.parcial.codigotransapp.services.persona.PersonaServiceImpl;
import com.parcial.codigotransapp.util.ActionBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistroVehiculoActivity extends AppCompatActivity {

    @BindView(R.id.txt_nombre)
    EditText txtNombre;

    @BindView(R.id.txt_placa)
    EditText txtPlaca;

    @BindView(R.id.txt_celular)
    EditText txtCelular;

    PersonaDTO persona;
    Persona personaActualizar;
    private Integer documentoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vehiculo);
        ButterKnife.bind(this);
        personaActualizar=(Persona) getIntent().getSerializableExtra("persona");
        if(persona!=null){
            txtPlaca.setText(persona.getPlaca());
            txtNombre.setText(persona.getNombre());
            txtCelular.setText(persona.getCelular());
        }

        persona = new PersonaDTO();
        ActionBarUtil.getInstance(this, false).setToolBar(getString(R.string.registro_persona), getString(R.string.insertar));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            guardarInformacion();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void guardarInformacion() {
        PersonaServiceImpl personaService = new PersonaServiceImpl(this);

        persona.setPlaca(txtPlaca.getText().toString());
        persona.setNombre(txtNombre.getText().toString());
        persona.setCelular(txtCelular.getText().toString());
        personaService.insertar(persona);
        Intent intent = new Intent(RegistroVehiculoActivity.this,ListaVehiculo    .class);
        startActivity(intent);
    }
}