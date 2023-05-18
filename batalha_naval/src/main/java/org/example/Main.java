package org.example;

import org.example.controller.GameController;
import org.example.model.mapa.Mapa;
import org.example.view.Tela;

public class Main {
    public static void main(String[] args) {
        Tela tela = Tela.getInstance();
        tela.printBanner();
        GameController gameController = new GameController();
        gameController.runGame();
        tela.close();
    }
}