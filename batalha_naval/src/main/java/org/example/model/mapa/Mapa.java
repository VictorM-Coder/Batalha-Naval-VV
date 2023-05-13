package org.example.model.mapa;

import org.example.enums.Position;
import org.example.model.matriz.Matriz;
import org.example.model.barco.Barco;
import org.example.model.barco.factory.*;
import org.example.model.coordenada.Coordenada;

public class Mapa {
    private Barco submarino;
    private Barco portaAvioes;
    private Barco[] rebocadores;
    private Barco[] contraTorpedeiros;
    private Matriz matriz;

    public Mapa(){
        this.rebocadores = new Barco[2];
        this.contraTorpedeiros = new Barco[2];
        this.matriz = new Matriz();
    }

    public char getCharNasCoordenadas(int linha, int coluna) {
        return this.matriz.getCharNasCoordenadas(linha, coluna);
    }

    public void setCoordenadasSubmarino(int linha, int coluna) {
        this.submarino = this.alocarBarco(new SubmarinoFactory(), new Coordenada(linha, coluna), Position.HORIZONTAL);
    }

    public void setCoordenadasPortaAvioes(Coordenada coordenada, Position position) {
        this.portaAvioes = this.alocarBarco(new PortaAvioesFactory(), coordenada, position);
    }

    public void setCoordenadasRebocador(Coordenada coordenada, Position position, int indexRebocador){
        if (indexRebocador < 0 || indexRebocador > 1) throw new ArrayIndexOutOfBoundsException("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas");
        this.rebocadores[indexRebocador] = this.alocarBarco(new RebocadorFactory(), coordenada, position);
    }

    public void setCoordenadasContraTorpedeiro(Coordenada coordenada, Position position, int indexContraTorpedeiro) {
        if (indexContraTorpedeiro < 0 || indexContraTorpedeiro > 1) throw new ArrayIndexOutOfBoundsException("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas");
        this.contraTorpedeiros[indexContraTorpedeiro] = this.alocarBarco(new ContraTorpedeiroFactory(), coordenada, position);
    }

    public char[][] getMapa(){
        return this.matriz.getMapa();
    }

    private Barco alocarBarco(BarcoFactory factory, Coordenada coordenada, Position position){
        Barco barco = factory.criarNovoBarco();
        this.matriz.alocarBarco(factory.criarNovoBarco(), coordenada, position);
        return barco;
    }
}
