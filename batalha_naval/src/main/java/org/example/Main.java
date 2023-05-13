package org.example;

import org.example.enums.Position;
import org.example.model.coordenada.Coordenada;
import org.example.model.mapa.Mapa;
import org.example.view.Tela;

public class Main {
    public static void main(String[] args) {
        Tela.printBanner();
        Mapa mapa = new Mapa();

        mapa.setCoordenadasSubmarino(0, 0);
        mapa.setCoordenadasRebocador(new Coordenada(1, 0), Position.HORIZONTAL, 0);
        mapa.setCoordenadasRebocador(new Coordenada(2, 0), Position.HORIZONTAL, 1);
        mapa.setCoordenadasContraTorpedeiro(new Coordenada(3, 0), Position.HORIZONTAL, 0);
        mapa.setCoordenadasContraTorpedeiro(new Coordenada(4, 0), Position.HORIZONTAL, 1);
        mapa.setCoordenadasPortaAvioes(new Coordenada(5, 0), Position.HORIZONTAL);

        mapa.setCoordenadasSubmarino(0, 2);
        mapa.setCoordenadasRebocador(new Coordenada(0, 9), Position.VERTICAL, 0);
        mapa.setCoordenadasRebocador(new Coordenada(3, 9), Position.VERTICAL, 1);
        mapa.setCoordenadasContraTorpedeiro(new Coordenada(0, 8), Position.VERTICAL, 0);
        mapa.setCoordenadasContraTorpedeiro(new Coordenada(0, 7), Position.VERTICAL, 1);
        mapa.setCoordenadasPortaAvioes(new Coordenada(0, 6), Position.VERTICAL);
        char[][] mapaMatriz = mapa.getMapa();

        Tela.printMapa(mapaMatriz);
    }
}