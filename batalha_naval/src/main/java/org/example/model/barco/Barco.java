package org.example.model.barco;

import org.example.model.coordenada.Coordenada;

import java.util.List;

public abstract class Barco {
    private List<Coordenada> coordenadas;
    private int partesAfundadas;
    protected final int partes;

    protected Barco(int partes) {
        this.partesAfundadas = 0;
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

    public void afundarParte(){
        if (!estaAfundado()){
            this.partesAfundadas++;
        }
    }

    public boolean estaAfundado(){
        return partesAfundadas >= partes;
    }
}
