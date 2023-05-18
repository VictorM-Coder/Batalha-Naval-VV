package org.example.model.matriz;

import org.example.enums.Position;
import org.example.enums.StatusTiro;
import org.example.exception.CoordenadaInvalidaException;
import org.example.model.barco.Barco;
import org.example.model.coordenada.Coordenada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matriz {
    private char[][] mapa;
    private List<Barco> barcos;
    private List<Coordenada> coordenadasBarcos;
    private List<Coordenada> coordenadasDescobertas;

    public Matriz(){
        this.barcos = new ArrayList<>();
        this.coordenadasBarcos = new ArrayList<>();
        this.coordenadasDescobertas = new ArrayList<>();
        this.mapa = new char[10][10];
        for (char[] chars : this.mapa) {
            Arrays.fill(chars, ' ');
        }
    }

    public StatusTiro disparar(Coordenada coordenada){
        if (!coordenadasDescobertas.contains(coordenada)){
            coordenadasDescobertas.add(coordenada);

            if (coordenadaEstaLivre(coordenada)){
                this.mapa[coordenada.getLinha()][coordenada.getColuna()] = '*';
                return StatusTiro.TIRO_NA_AGUA;
            }

            Barco barco = getBarcoByCoordenada(coordenada);
            barco.afundarParte();
            if (barco.estaAfundado()){
                return StatusTiro.AFUNDOU;
            }else{
                return StatusTiro.ACERTOU;
            }


        }else {
            return StatusTiro.LOCAL_REPETIDO;
        }
    }


    public char[][] getMapa() {
        return this.mapa;
    }

    public char getCharNasCoordenadas(Coordenada coordenada) {
        return this.mapa[coordenada.getLinha()][coordenada.getColuna()];
    }

    public void alocarBarco(Barco barco, Coordenada coordenada, Position position) throws CoordenadaInvalidaException{
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
                this.coordenadasBarcos.addAll(coordenadas);
                alocarCoordenadas(coordenadas);
                this.barcos.add(barco);
            }else {
                throw new CoordenadaInvalidaException("as coordenada passadas são inválidas, tente um intervalo livre");
            }
        }else{
            throw new CoordenadaInvalidaException("as coordenada passadas são inválidas, tente um intervalo livre");
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

    private Barco getBarcoByCoordenada(Coordenada coordenada){
        return (Barco) this.barcos.stream()
                .filter(barco -> barco.contemCoordenadas(coordenada))
                .toArray()[0];
    }

    private boolean coordenadaEstaLivre(Coordenada coordenada){
        return !this.coordenadasBarcos.contains(coordenada);
    }
}
