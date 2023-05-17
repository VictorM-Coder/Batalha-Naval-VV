package org.example;

import org.example.view.Tela;

public class Main {
    public static void main(String[] args) {
        Tela tela = Tela.getInstance();
        tela.printBanner();
        tela.iniciarJogo();
        tela.close();
    }
}