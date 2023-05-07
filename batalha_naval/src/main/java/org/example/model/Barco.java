package org.example.model;

import java.util.List;

public class Barco {
    private List<Coordenada> coordenadas;
    private boolean afundado;
    private int partes;


    public Barco(int partes){
        this.partes = partes;
    }

    public boolean contemCoordenadas(Coordenada coordenada){
        return this.coordenadas.contains(coordenada);
    }

    public int getPartes() {
        return partes;
    }

    public void setCoordenadas(List<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }
}
