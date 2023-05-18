package org.example.controller;

import org.example.enums.Position;
import org.example.enums.StatusTiro;
import org.example.exception.CoordenadaInvalidaException;
import org.example.model.coordenada.Coordenada;
import org.example.model.mapa.Mapa;

import java.util.Scanner;

public class GameController {
    private Mapa mapajogador1;
    private Mapa mapaJogador2;
    private Scanner scanner;

    public GameController(){
        this.mapajogador1 = new Mapa();
        this.mapaJogador2 = new Mapa();
        this.scanner = new Scanner(System.in);
    }

    public void runGame() {
        posicionarBarcosJogador1();
        posicionarBarcosJogador2();
        iniciarDisparos();
    }

    private void iniciarDisparos(){
        while (true) {
            dispararJogador1();
            if (mapaJogador2.todosOsBarcosForamAfundados()) {
                System.out.println("O jogador 1 venceu! parabéns");
                break;
            }
            dispararJogador2();
            if (mapajogador1.todosOsBarcosForamAfundados()) {
                System.out.println("O jogador 2 venceu! parabéns");
                break;
            }
        }
    }

    private void dispararJogador1(){
        System.out.println();
        System.out.println("Turno de disparo do jogador 1");
        this.realizarDisparo(this.mapaJogador2);
        System.out.println("----------------------------------------------");
        this.printMapa(this.mapaJogador2.getMapa());
    }

    private void dispararJogador2(){
        System.out.println();
        System.out.println("Turno de disparo do jogador 2");
        this.realizarDisparo(this.mapajogador1);
        System.out.println("----------------------------------------------");
        this.printMapa(this.mapajogador1.getMapa());
    }

    private void realizarDisparo(Mapa mapa){
        StatusTiro statusTiro = mapa.disparar(this.scanCoodernada());
        switch (statusTiro) {
            case ACERTOU -> System.out.println("Você atingiu um barco!");
            case LOCAL_REPETIDO -> {
                System.out.println("Local repetido! tente novamento");
                realizarDisparo(mapa);
            }
            case AFUNDOU -> System.out.println("PArabéns! você afundou esse barco!");
            case TIRO_NA_AGUA -> System.out.println("Por pouco! um tiro na água");
        }
    }

    private void posicionarBarcosJogador1(){
        System.out.println("Jogador 1 posicione os seus barcos");
        this.posicionarBarcos(this.mapajogador1);
        System.out.println("----------------Mapa Jogador 1----------------");
        this.printMapa(this.mapajogador1.getMapa());
        System.out.println("----------------------------------------------");
    }

    private void posicionarBarcosJogador2(){
        System.out.println("Jogador 2 posicione os seus barcos");
        this.posicionarBarcos(this.mapaJogador2);
        System.out.println("----------------Mapa Jogador 2----------------");
        this.printMapa(this.mapaJogador2.getMapa());
        System.out.println("----------------------------------------------");
    }

    private void printMapa(char[][] mapa){
        System.out.println("  | A | B | C | D | E | F | H | I | J | K |");
        for (int cont = 0; cont <= 9; cont++){
            System.out.print(cont);
            for (int cont1 = 0; cont1 <= 9; cont1++){
                System.out.print(" | "+ mapa[cont][cont1]);
            }
            System.out.println(" |");
        }
    }

    private void posicionarBarcos(Mapa mapa){
        System.out.println("Posicione o submarino");
        mapa.setCoordenadasSubmarino(this.scanCoodernada());

        while (true) {
            try {
                System.out.println("Posicione o primeiro rebocador");
                mapa.setCoordenadasRebocador(this.scanCoodernada(), this.scanPosicao(), 0);
                break;
            } catch (CoordenadaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Posicione o segundo rebocador");
                mapa.setCoordenadasRebocador(this.scanCoodernada(), this.scanPosicao(), 1);
                break;
            }catch (CoordenadaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Posicione o primeiro ContraTorpedeiro");
                mapa.setCoordenadasContraTorpedeiro(this.scanCoodernada(), this.scanPosicao(), 0);
                break;
            } catch (CoordenadaInvalidaException e){
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Posicione o segundo ContraTorpedeiro");
                mapa.setCoordenadasContraTorpedeiro(this.scanCoodernada(), this.scanPosicao(), 1);
                break;
            } catch (CoordenadaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Posicione o porta aviões");
                mapa.setCoordenadasPortaAvioes(this.scanCoodernada(), this.scanPosicao());
                break;
            } catch (CoordenadaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Position scanPosicao(){
        int valor;

        while (true) {
            try {
                System.out.print("Defina a posição do barco [0]Horizontal | [1]Vertical: ");
                valor = scanner.nextInt();
                if (valor == 0 || valor == 1) break;
                System.out.println("Valor inválido! tente novamente");
            } catch (Exception e){
                System.out.println("Entrada inválida! Tente novamente");
            }
        }

        return (valor == 0)? Position.HORIZONTAL: Position.VERTICAL;
    }

    private Coordenada scanCoodernada() {
        Coordenada coordenada;

        while (true){
            try {
                System.out.print("Deina o valor inicial para linha: ");
                int linha = scanner.nextInt();
                System.out.print("Deina o valor inicial para coluna: ");
                int coluna = scanner.nextInt();
                coordenada = new Coordenada(linha, coluna);
                break;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Entrada inválida!");
            }
        }

        return coordenada;
    }
}
