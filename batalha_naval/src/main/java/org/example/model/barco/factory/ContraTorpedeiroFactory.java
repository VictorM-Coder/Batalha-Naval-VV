package org.example.model.barco.factory;

import org.example.model.barco.Barco;

public class ContraTorpedeiroFactory implements BarcoFactory{
    @Override
    public Barco criarNovoBarco() {
        return new ContraTorpedeiro();
    }
}
