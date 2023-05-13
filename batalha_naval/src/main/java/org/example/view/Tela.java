package org.example.view;

public class Tela {
    public static void printBanner(){
        System.out.println("  ____        _        _ _             _   _                  _ \n" +
                " | __ )  __ _| |_ __ _| | |__   __ _  | \\ | | __ ___   ____ _| |\n" +
                " |  _ \\ / _` | __/ _` | | '_ \\ / _` | |  \\| |/ _` \\ \\ / / _` | |\n" +
                " | |_) | (_| | || (_| | | | | | (_| | | |\\  | (_| |\\ V / (_| | |\n" +
                " |____/ \\__,_|\\__\\__,_|_|_| |_|\\__,_| |_| \\_|\\__,_| \\_/ \\__,_|_|\n" +
                "                                                                ");
    }

    public static void printMapa(char[][] mapa){
        System.out.println("  | A | B | C | D | E | F | H | I | J | K |");
        for (int cont = 0; cont <= 9; cont++){
            System.out.print(cont);
            for (int cont1 = 0; cont1 <= 9; cont1++){
                System.out.print(" | "+ mapa[cont][cont1]);
            }
            System.out.println(" |");
        }
    }
}
