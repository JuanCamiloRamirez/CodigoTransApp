package com.parcial.codigotransapp.services.login;

import android.util.Log;

import com.parcial.codigotransapp.credencials.Credencial;
import com.parcial.codigotransapp.dao.Dao;

public class LoginModel implements Login.Model {

    private Credencial credencial;
    private Login.Presenter presenter;
    private Dao dao;

    public LoginModel(Login.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void setCredenciales(Credencial credencial) {
        if(credencial == null){
            credencial = new Credencial();
        }
        this.credencial = credencial;
    }

    @Override
    public void validarInformacion() {
        if(usuarioEsValido()){
            presenter.usuarioRequerido();
        }

        if(contrasenaEsValida()){
            presenter.contrasenaRequerida();
        }

        if(validarCredenciales()){
            presenter.denegarCredenciales();
        } else {
            presenter.login();
        }

    }

    @Override
    public void setDao(Dao dao){
        this.dao = dao;
    }

    private boolean validarCredenciales() {
        return !dao.allowAccess().getUsuario().equals(credencial.getUsuario()) || !dao.allowAccess().getContasena().equals(credencial.getContasena());
    }

    private boolean contrasenaEsValida() {
        return credencial.getContasena() == null || "".equals(credencial.getContasena());
    }

    private boolean usuarioEsValido() {
        return credencial.getUsuario() == null || "".equals(credencial.getUsuario());
    }
}
