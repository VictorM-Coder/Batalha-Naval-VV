package org.example.model;

import org.example.model.barco.Barco;
import org.example.model.barco.factory.SubmarinoFactory;
import org.example.model.coordenada.Coordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BarcoTeste {
    private SubmarinoFactory factory;

    @BeforeEach
    void setup(){
        this.factory = new SubmarinoFactory();
    }
    @Test
    public void contemCoordenadas_Deve_Retornar_True_Quando_O_Barco_Possui_As_Coordenadas_Passadas(){
        final int linha = 0, coluna = 0;
        Barco barco = factory.criarNovoBarco();
        barco.setCoordenadas(List.of(new Coordenada(linha, coluna)));

        assertTrue(barco.contemCoordenadas(new Coordenada(linha, coluna)));
    }

    @Test
    public void contemCoordenadas_Deve_Retornar_False_Quando_O_Barco_Nao_Possui_As_Coordenadas_Passadas(){
        final int linha = 0, coluna = 0;
        Barco barco = factory.criarNovoBarco();
        barco.setCoordenadas(List.of(new Coordenada(linha, coluna)));

        assertFalse(barco.contemCoordenadas(new Coordenada(1, 1)));
    }
}
