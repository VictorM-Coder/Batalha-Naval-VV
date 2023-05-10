package org.example.model.barco.factory;

import org.example.model.barco.Barco;
import org.example.model.barco.PortaAvioes;

public class PortaAvioesFactory implements BarcoFactory{
    @Override
    public Barco criarNovoBarco() {
        return new PortaAvioes();
    }
}
