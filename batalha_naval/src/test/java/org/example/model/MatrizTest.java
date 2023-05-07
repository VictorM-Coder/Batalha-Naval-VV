package org.example.model;

import org.example.enums.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void setCoordenadasSubmarino_Deve_Colocar_Um_Submarino_Nas_Coordenadas_Definidas(){
        final int coluna = 9, linha = 0;
        //Ação
        matriz.setCoordenadasSubmarino(linha, coluna);
        //Asserção
        assertEquals(matriz.getCharNasCoordenadas(linha, coluna), 'X');
    }

    @Test
    public void setCoordenadasRebocador_Deve_Colocar_Um_Rebocador_Nas_Coordenadas_Definidas(){
        final int coluna = 8, linha = 0;
        //Ação
        matriz.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.VERTICAL, 0);

        //Asserção
        assertEquals(matriz.getCharNasCoordenadas(linha, coluna), 'X');
        assertEquals(matriz.getCharNasCoordenadas(linha, coluna+1), 'X');
    }
}
