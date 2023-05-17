package org.example.view;

import java.util.Scanner;

public class Tela {
    private static Tela instance;
    private Scanner scanner;
    private Tela(){
        this.scanner = new Scanner(System.in);
    }

    public static Tela getInstance(){
        if (instance == null) instance = new Tela();
        return instance;
    }
    public void printBanner(){
        System.out.println("  ____        _        _ _             _   _                  _ \n" +
                " | __ )  __ _| |_ __ _| | |__   __ _  | \\ | | __ ___   ____ _| |\n" +
                " |  _ \\ / _` | __/ _` | | '_ \\ / _` | |  \\| |/ _` \\ \\ / / _` | |\n" +
                " | |_) | (_| | || (_| | | | | | (_| | | |\\  | (_| |\\ V / (_| | |\n" +
                " |____/ \\__,_|\\__\\__,_|_|_| |_|\\__,_| |_| \\_|\\__,_| \\_/ \\__,_|_|\n" +
                "                                                                ");
    }

    public void printMapa(char[][] mapa){
        System.out.println("  | A | B | C | D | E | F | H | I | J | K |");
        for (int cont = 0; cont <= 9; cont++){
            System.out.print(cont);
            for (int cont1 = 0; cont1 <= 9; cont1++){
                System.out.print(" | "+ mapa[cont][cont1]);
            }
            System.out.println(" |");
        }
    }

    public void iniciarJogo(){
        while (true){
            System.out.print("Deseja iniciar um novo? [S/N]: ");
            String entrada;
            entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("S")){
                break;
            }else if (entrada.equalsIgnoreCase("N")){
                break;
            }
        }
    }
    public void close(){
        this.scanner.close();
    }
}
