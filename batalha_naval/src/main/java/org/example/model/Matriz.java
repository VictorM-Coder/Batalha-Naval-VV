package org.example.model;

import org.example.enums.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matriz {
    private char[][] mapa;
    private Barco submarino;
    private Barco[] rebocadores;
    private List<Coordenada> coordenadaUsadas;

    public Matriz(){
        this.submarino = new Barco(1);
        this.rebocadores = new Barco[]{new Barco(2), new Barco(2)};

        this.coordenadaUsadas = new ArrayList<>();
        this.mapa = new char[10][10];
        for (char[] chars : this.mapa) {
            Arrays.fill(chars, ' ');
        }
    }

    public void setCoordenadasRebocador(Coordenada coordenada, Position position, int indexRebocador){
        Barco rebocador = new Barco(2);
        this.alocarBarco(rebocador, coordenada, Position.HORIZONTAL);
        this.rebocadores[indexRebocador] = rebocador;
    }

    public void setCoordenadasSubmarino(int linha, int coluna) {
        Barco submarino = new Barco(1);
        this.alocarBarco(submarino, new Coordenada(linha, coluna), Position.HORIZONTAL);
        this.submarino = submarino;
    }

    public char[][] getMapa() {
        return this.mapa;
    }

    public char getCharNasCoordenadas(int linha, int coluna) {
        return this.mapa[linha][coluna];
    }

    private void alocarBarco(Barco barco, Coordenada coordenada, Position position){
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
            }
        }
    }

    private void alocarCoordenadas(List<Coordenada> coordenadas){
        for (Coordenada coordenada: coordenadas){
            this.mapa[coordenada.getLinha()][coordenada.getColuna()] = 'X';
        }
    }

    private boolean coordenadasEstaoLivres(List<Coordenada> coordenadas){
        for (Coordenada coordenada : coordenadas){
            if (!this.coordenadaEstaLivre(coordenada)){
                return false;
            }
        }
        return true;
    }

    private boolean coordenadaEstaLivre(Coordenada coordenada){
        return !this.coordenadaUsadas.contains(coordenada);
    }
}
