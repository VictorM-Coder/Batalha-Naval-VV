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
