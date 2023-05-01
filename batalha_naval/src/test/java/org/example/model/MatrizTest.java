package org.example.model;

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
        Coordenadas coordenadas = matriz.getCoordenadasSubmarino();

        //Asserção
        assertEquals(coordenadas.getColuna(), coluna);
        assertEquals(coordenadas.getLinha(), linha);
        assertEquals(matriz.getCharNasCoordenadas(linha, coluna), Matriz.SIMBOLO_SUBMARINO);
    }

    @Test
    public void setCoordenadasSubmarino_Deve_Lancar_ArrayIndexOutOfBoundsException_Quando_Um_Valor_De_Coluna_Ou_Linha_For_Menor_Do_Que_Zero_Ou_Maior_Do_Que_Nove(){
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> matriz.setCoordenadasSubmarino(-1, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> matriz.setCoordenadasSubmarino(0, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> matriz.setCoordenadasSubmarino(9, 10));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> matriz.setCoordenadasSubmarino(10, 9));
    }
}
