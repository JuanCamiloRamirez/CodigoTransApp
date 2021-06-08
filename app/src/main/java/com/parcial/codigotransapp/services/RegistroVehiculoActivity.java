package com.parcial.codigotransapp.services;

import androidx.appcompat.app.AlertDialog;
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
        persona = new PersonaDTO();
        personaActualizar=(Persona) getIntent().getSerializableExtra("persona");
        if(persona!=null){
            txtPlaca.setText(persona.getPlaca());
            txtNombre.setText(persona.getNombre());
            txtCelular.setText(persona.getCelular());
        }
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
        if (persona != null) {

            persona.setPlaca(txtPlaca.getText().toString());
            persona.setNombre(txtNombre.getText().toString());
            persona.setCelular(txtCelular.getText().toString());


            //confirmar insert en la DB
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistroVehiculoActivity.this);

            //ventana priorizada
            builder.setCancelable(false);
            builder.setTitle("Confirmar");
            builder.setMessage("¿Esta seguro de actualizar la información?");
            builder.setPositiveButton("Confirmar acción",
                    (dialog, which) -> {
                        Intent intent = new Intent(this, ListaVehiculo.class);
                        personaService.actualizar(persona, intent, persona.getIdPersona());
                        goToListaVehiculo();
                    });
            builder.setNegativeButton(android.R.string.cancel,
                    (dialog, which) -> {
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            PersonaDTO nuevaPersonaDTO = new PersonaDTO();

            nuevaPersonaDTO.setPlaca(txtPlaca.getText().toString());
            nuevaPersonaDTO.setNombre(txtNombre.getText().toString());
            nuevaPersonaDTO.setCelular(txtCelular.getText().toString());


            //confirmar insert en la DB
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistroVehiculoActivity.this);

            //ventana priorizada
            builder.setCancelable(false);
            builder.setTitle("Confirmar");
            builder.setMessage("¿Esta seguro de guardar la información?");
            builder.setPositiveButton("Confirmar acción",
                    (dialog, which) -> {
                        Intent intent = new Intent(this, ListaVehiculo.class);
                        personaService.insertar(nuevaPersonaDTO);
                        goToListaVehiculo();
                    });
            builder.setNegativeButton(android.R.string.cancel,
                    (dialog, which) -> {
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
           }
        }

        public void goToListaVehiculo(){
            Intent intent = new Intent(this,ListaVehiculo.class);
            startActivity(intent);
        }
}