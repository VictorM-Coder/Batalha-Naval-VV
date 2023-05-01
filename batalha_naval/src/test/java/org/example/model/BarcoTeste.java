package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BarcoTeste {

    @Test
    public void contemCoordenadas_Deve_Retornar_True_Quando_O_Barco_Possui_As_Coordenadas_Passadas(){
        final int linha = 0, coluna = 0;
        Barco barco = new Barco(1);
        barco.setCoordenadas(List.of(new Coordenadas(linha, coluna)));

        assertTrue(barco.contemCoordenadas(new Coordenadas(linha, coluna)));
    }

    @Test
    public void contemCoordenadas_Deve_Retornar_False_Quando_O_Barco_Nao_Possui_As_Coordenadas_Passadas(){
        final int linha = 0, coluna = 0;
        Barco barco = new Barco(1);
        barco.setCoordenadas(List.of(new Coordenadas(linha, coluna)));

        assertFalse(barco.contemCoordenadas(new Coordenadas(1, 1)));
    }
}
