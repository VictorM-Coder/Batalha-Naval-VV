package org.example.model;

import org.example.enums.Position;
import org.example.model.barco.Barco;
import org.example.model.barco.factory.BarcoFactory;
import org.example.model.barco.factory.RebocadorFactory;
import org.example.model.barco.factory.SubmarinoFactory;

public class Mapa {
    private Barco submarino;
    private Barco[] rebocadores;
    private Matriz matriz;

    public Mapa(){
        this.rebocadores = new Barco[2];
        this.matriz = new Matriz();
    }

    public char getCharNasCoordenadas(int linha, int coluna) {
        return this.matriz.getCharNasCoordenadas(linha, coluna);
    }

    public void setCoordenadasRebocador(Coordenada coordenada, Position position, int indexRebocador){
        if (indexRebocador < 0 || indexRebocador > 1) throw new ArrayIndexOutOfBoundsException("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas");

        BarcoFactory factory = new RebocadorFactory();
        Barco rebocador = factory.criarNovoBarco();
        this.matriz.alocarBarco(rebocador, coordenada, position);
        this.rebocadores[indexRebocador] = rebocador;
    }

    public void setCoordenadasSubmarino(int linha, int coluna) {
        BarcoFactory factory = new SubmarinoFactory();
        Barco submarino = factory.criarNovoBarco();
        this.matriz.alocarBarco(submarino, new Coordenada(linha, coluna), Position.HORIZONTAL);
        this.submarino = submarino;
    }
}
