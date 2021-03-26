package com.parcial.codigotransapp.services.login;

import com.parcial.codigotransapp.credencials.Credencial;
import com.parcial.codigotransapp.dao.Dao;

public interface Login {

    interface Model{
        void setCredenciales(Credencial credencial);
        void validarInformacion();
        void setDao(Dao dao);
    }

    interface View{
        void validarInformacion();
        Credencial obtenerCredenciales();
        void denegarCredenciales();
        void usuarioRequerido();
        void contrasenaRequerida();
        void login();

    }

    interface Presenter{
        void validarInformacion();
        void usuarioRequerido();
        void contrasenaRequerida();
        void login();
        void denegarCredenciales();
    }
}
