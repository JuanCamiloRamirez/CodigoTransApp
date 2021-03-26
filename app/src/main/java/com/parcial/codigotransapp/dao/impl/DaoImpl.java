package com.parcial.codigotransapp.dao.impl;

import com.parcial.codigotransapp.credencials.Credencial;
import com.parcial.codigotransapp.dao.Dao;

public class DaoImpl implements Dao {

    @Override
    public Credencial allowAccess() {
        Credencial credencial = new Credencial();
        credencial.setUsuario("admin");
        credencial.setContasena("1234");
        return credencial;
    }
}
