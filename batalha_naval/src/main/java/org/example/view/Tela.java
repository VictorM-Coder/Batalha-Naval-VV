package org.example.view;

public class Tela {
    private static Tela instance;

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
}
