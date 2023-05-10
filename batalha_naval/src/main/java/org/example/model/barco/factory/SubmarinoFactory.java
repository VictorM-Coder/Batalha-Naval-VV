package org.example.model.barco.factory;

import org.example.model.barco.Barco;
import org.example.model.barco.Submarino;

public class SubmarinoFactory implements BarcoFactory{
    @Override
    public Barco criarNovoBarco() {
        return new Submarino();
    }
}
