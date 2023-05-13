package org.example.model.mapa;

import org.example.enums.Position;
import org.example.enums.StatusTiro;
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

    public char getCharNasCoordenadas(Coordenada coordenada) {
        return this.matriz.getCharNasCoordenadas(coordenada);
    }

    public void setCoordenadasSubmarino(Coordenada coordenada) {
        this.submarino = this.alocarBarco(new SubmarinoFactory(), coordenada, Position.HORIZONTAL);
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

    public StatusTiro disparar(Coordenada coordenada) {
        return this.matriz.disparar(coordenada);
    }
}
