package org.example.model;

import java.util.List;

public class Barco {
    private List<Coordenadas> coordenadas;
    private boolean afundado;
    private int partes;

    public Barco(int partes){
        this.partes = partes;
    }

    public boolean contemCoordenadas(Coordenadas coordenadas){
        return this.coordenadas.contains(coordenadas);
    }

    public void setCoordenadas(List<Coordenadas> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Coordenadas> getCoordenadas() {
        return coordenadas;
    }
}
