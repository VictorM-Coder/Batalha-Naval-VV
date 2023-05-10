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

        mapa.setCoordenadasSubmarino(linha, coluna);

        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna));
    }

    @Test
    public void setCoordenadasRebocador_Deve_Colocar_Um_Rebocador_Nas_Coordenadas_Definidas(){
        final int coluna = 8, linha = 0;

        mapa.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.HORIZONTAL, 0);

        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+1));
    }

    @Test
    public void setCoordenadasRebocador_Deve_Lancar_Um_ArrayIndexOutOfBoundsException_Quando_O_Index_For_Diferente_De_0_Ou_1(){
        final int coluna = 8, linha = 0;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapa.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.HORIZONTAL, -1));
        ArrayIndexOutOfBoundsException exception2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapa.setCoordenadasRebocador(new Coordenada(linha, coluna), Position.HORIZONTAL, 2));

        assertEquals("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas", exception.getMessage());
        assertEquals("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas", exception2.getMessage());
    }

    @Test
    public void setCoordenadasContraTorpedeiro_Deve_Colocar_Um_ContraTorpedeiro_Nas_Coordenadas_Definidas(){
        final int coluna = 7, linha = 0;

        mapa.setCoordenadasContraTorpedeiro(new Coordenada(linha, coluna), Position.HORIZONTAL, 0);

        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+1));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+2));
    }

    @Test
    public void setCoordenadasContraTorpedeiro_Deve_Lancar_Um_ArrayIndexOutOfBoundsException_Quando_O_Index_For_Diferente_De_0_Ou_1(){
        final int coluna = 7, linha = 0;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapa.setCoordenadasContraTorpedeiro(new Coordenada(linha, coluna), Position.HORIZONTAL, -1));
        ArrayIndexOutOfBoundsException exception2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapa.setCoordenadasContraTorpedeiro(new Coordenada(linha, coluna), Position.HORIZONTAL, 2));

        assertEquals("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas", exception.getMessage());
        assertEquals("Valor inválido, os indexs válidos para rebodar são 0 e 1 apenas", exception2.getMessage());
    }

    @Test
    public void setCoordenadasPortaAvioes_Deve_Colocar_Um_PortaAvioes_Nas_Coordenadas_Definidas(){
        final int coluna = 6, linha = 0;
        final Coordenada coordenada = new Coordenada(linha, coluna);

        mapa.setCoordenadasPortaAvioes(coordenada, Position.HORIZONTAL);

        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+1));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+2));
        assertEquals('X', mapa.getCharNasCoordenadas(linha, coluna+3));
    }
}
