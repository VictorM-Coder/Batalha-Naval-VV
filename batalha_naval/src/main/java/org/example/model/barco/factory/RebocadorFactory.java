package org.example.model.barco.factory;

import org.example.model.barco.Barco;
import org.example.model.barco.Rebocador;

public class RebocadorFactory implements BarcoFactory{
    @Override
    public Barco criarNovoBarco() {
        return new Rebocador();
    }
}
