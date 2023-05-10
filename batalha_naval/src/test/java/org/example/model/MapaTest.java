package org.example.model;

import org.example.enums.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapaTest {
    private Mapa mapa;
    @BeforeEach
    void setup(){
        this.mapa = new Mapa();
    }
    @Test
    public void setCoordenadasSubmarino_Deve_Colocar_Um_Submarino_Nas_Coordenadas_Definidas(){
        final int coluna = 9, linha = 0;
        //Ação
        mapa.setCoordenadasSubmarino(linha, coluna);
        //Asserção
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna));
    }

    @Test
    public void setCoordenadasRebocador_Deve_Colocar_Um_Rebocador_Nas_Coordenadas_Definidas(){
        final int coluna = 8, linha = 0;
        //Ação
        mapa.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.HORIZONTAL, 0);

        //Asserção
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+1));
    }

    @Test
    public void setCoordenadasRebocador_Deve_Lancar_Um_ArrayIndexOutOfBoundsException_Quando_O_Index_For_Diferente_De_0_Ou_1(){
        final int coluna = 8, linha = 0;
        //Ação
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapa.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.HORIZONTAL, -1));
        ArrayIndexOutOfBoundsException exception2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapa.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.HORIZONTAL, 2));
        //Asserção
        assertEquals("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas", exception.getMessage());
        assertEquals("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas", exception2.getMessage());
    }
}
