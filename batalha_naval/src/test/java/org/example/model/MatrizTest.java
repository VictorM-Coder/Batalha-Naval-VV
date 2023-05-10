package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MatrizTest {
    private Matriz matriz;
    @BeforeEach
    void setup(){
        this.matriz = new Matriz();
    }

    @Test
    public void Uma_Matriz_Deve_Ter_Dez_Linhas_E_Dez_Colunas_Ao_Ser_Iniciada(){
        //Ação
        char[][] campo = matriz.getMapa();

        //Asserção
        assertEquals(campo.length, 10);
        assertEquals(campo[0].length, 10);
    }

    @Test
    public void Uma_Matriz_Deve_Ser_Completamente_Preenchiada_Por_Espacos_Em_Branco_Ao_Ser_Iniciada(){
        //Ação
        char[][] campo = matriz.getMapa();

        //Asserção
        for (char[] chars : campo) {
            for (char aChar : chars) {
                if (aChar != ' ') fail();
            }
        }
    }
}
