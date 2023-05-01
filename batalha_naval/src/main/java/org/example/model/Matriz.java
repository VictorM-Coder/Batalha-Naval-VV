package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matriz {
    public static final char SIMBOLO_SUBMARINO = 'S';
    private char[][] mapa;
    private Barco submarino;
    private Barco[] rebocadores;
    private List<Coordenadas> coordenadasUsadas;

    public Matriz(){
        this.submarino = new Barco(1);
        rebocadores = new Barco[]{new Barco(2), new Barco(2)};

        this.coordenadasUsadas = new ArrayList<>();
        this.mapa = new char[10][10];
        for (char[] chars : this.mapa) {
            Arrays.fill(chars, ' ');
        }
    }

    public void setCoordenadasRebocador(Coordenadas coordenadas, int indexRebocador){

    }
    public void setCoordenadasSubmarino(int linha, int coluna) {
        this.submarino.setCoordenadas(List.of(new Coordenadas(linha, coluna)));
        this.mapa[linha][coluna] = SIMBOLO_SUBMARINO;
    }

    public Coordenadas getCoordenadasSubmarino() {
        return this.submarino.getCoordenadas().get(0);
    }

    public char[][] getMapa() {
        return this.mapa;
    }

    public char getCharNasCoordenadas(int linha, int coluna) {
        return this.mapa[linha][coluna];
    }
}
