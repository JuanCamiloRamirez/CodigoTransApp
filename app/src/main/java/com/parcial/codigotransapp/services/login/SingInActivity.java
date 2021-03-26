package com.parcial.codigotransapp.services.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.credencials.Credencial;
import com.parcial.codigotransapp.services.Menu;
import com.parcial.codigotransapp.services.SingupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingInActivity extends AppCompatActivity implements Login.View {

    @BindView(R.id.usuario)
    EditText usuario;

    @BindView(R.id.password)
    EditText contrasena;

    Login.Presenter presenter;
    Credencial credencial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initComponent();
    }

    private void initComponent(){
        presenter = new LoginPresenter(this);
        credencial = new Credencial();
    }

    public void registro(View view) {
        Intent intent = new Intent(this, SingupActivity.class);
        startActivity(intent);
    }

    public void acceder(View view) {
        credencial.setUsuario(usuario.getText().toString());
        credencial.setContasena(contrasena.getText().toString());
        validarInformacion();
    }

    @Override
    public void validarInformacion() {
        presenter.validarInformacion();
    }

    @Override
    public Credencial obtenerCredenciales() {
        return credencial;
    }

    @Override
    public void denegarCredenciales() {
        Toast.makeText(getApplicationContext(), "el usuario o contraseña no son validos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void usuarioRequerido() {
        usuario.setError("requerido");
    }

    @Override
    public void contrasenaRequerida() {
        contrasena.setError("requerido");
    }

    @Override
    public void login() {
        startActivity(new Intent(this, Menu.class));
    }
}