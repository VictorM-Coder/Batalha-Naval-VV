package org.example.model.matriz;

import org.example.enums.Position;
import org.example.exception.CoordenadaInvalidaException;
import org.example.model.barco.Barco;
import org.example.model.coordenada.Coordenada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matriz {
    private char[][] mapa;
    private List<Coordenada> coordenadaUsadas;

    public Matriz(){
        this.coordenadaUsadas = new ArrayList<>();
        this.mapa = new char[10][10];
        for (char[] chars : this.mapa) {
            Arrays.fill(chars, ' ');
        }
    }

    public char[][] getMapa() {
        return this.mapa;
    }

    public char getCharNasCoordenadas(int linha, int coluna) {
        return this.mapa[linha][coluna];
    }

    public void alocarBarco(Barco barco, Coordenada coordenada, Position position){
        if (this.coordenadaEstaLivre(coordenada)){
            List<Coordenada> coordenadas = new ArrayList<>();
            coordenadas.add(coordenada);

            if (position == Position.HORIZONTAL){
                for (int cont = 0; cont < barco.getPartes(); cont++){
                    Coordenada novaCoordenada = new Coordenada(coordenada.getLinha(), coordenada.getColuna()+cont);
                    coordenadas.add(novaCoordenada);
                }
            }else {
                for (int cont = 0; cont < barco.getPartes(); cont++){
                    Coordenada novaCoordenada = new Coordenada(coordenada.getLinha()+cont, coordenada.getColuna());
                    coordenadas.add(novaCoordenada);
                }
            }

            if (this.coordenadasEstaoLivres(coordenadas)){
                barco.setCoordenadas(coordenadas);
                this.coordenadaUsadas.addAll(coordenadas);
                alocarCoordenadas(coordenadas);
            }else {
                throw new CoordenadaInvalidaException("as coordenada passadas são inválidas, tente um intervalo livre");
            }
        }else{
            throw new CoordenadaInvalidaException("as coordenada passadas são inválidas, tente um intervalo livre");
        }
    }

    public void alocarCoordenadas(List<Coordenada> coordenadas){
        for (Coordenada coordenada: coordenadas){
            this.mapa[coordenada.getLinha()][coordenada.getColuna()] = 'X';
        }
    }

    public boolean coordenadasEstaoLivres(List<Coordenada> coordenadas){
        for (Coordenada coordenada : coordenadas){
            if (!this.coordenadaEstaLivre(coordenada)){
                return false;
            }
        }
        return true;
    }

    public boolean coordenadaEstaLivre(Coordenada coordenada){
        return !this.coordenadaUsadas.contains(coordenada);
    }
}
