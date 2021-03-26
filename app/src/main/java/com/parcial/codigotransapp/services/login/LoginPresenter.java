package com.parcial.codigotransapp.services.login;

import com.parcial.codigotransapp.dao.impl.DaoImpl;

public class LoginPresenter implements Login.Presenter{

    private Login.View view;
    private Login.Model model;

    public LoginPresenter(Login.View view){
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void validarInformacion() {
        if(view != null){
            model.setDao(new DaoImpl());
            model.setCredenciales(view.obtenerCredenciales());
            model.validarInformacion();
        }
    }

    @Override
    public void usuarioRequerido() {
        if(view != null){
            view.usuarioRequerido();
        }
    }

    @Override
    public void contrasenaRequerida() {
        if(view != null){
            view.contrasenaRequerida();
        }
    }

    @Override
    public void login() {
        if(view != null){
            view.login();
        }
    }

    @Override
    public void denegarCredenciales() {
        if(view != null){
            view.denegarCredenciales();
        }
    }
}
