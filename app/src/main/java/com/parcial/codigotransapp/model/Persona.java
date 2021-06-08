package com.parcial.codigotransapp.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona implements Serializable {

    private Integer idPersona;
    private String nombre;
    private String celular;
    private String placa;
}
