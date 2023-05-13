package org.example.model;

import org.example.enums.Position;
import org.example.model.coordenada.Coordenada;
import org.example.model.mapa.Mapa;
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
        final Coordenada coordenada = new Coordenada(0, 9);

        mapa.setCoordenadasSubmarino(coordenada);

        assertEquals('X', mapa.getCharNasCoordenadas(coordenada));
    }

    @Test
    public void setCoordenadasRebocador_Deve_Colocar_Um_Rebocador_Nas_Coordenadas_Definidas(){
        final Coordenada coordenada = new Coordenada(0, 8);

        mapa.setCoordenadasRebocador(coordenada, Position.HORIZONTAL, 0);

        assertEquals('X', mapa.getCharNasCoordenadas(coordenada));
        assertEquals('X', mapa.getCharNasCoordenadas(new Coordenada(coordenada.getLinha(), coordenada.getColuna()+1)));
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
        final Coordenada coordenada = new Coordenada(0, 7);

        mapa.setCoordenadasContraTorpedeiro(coordenada, Position.HORIZONTAL, 0);

        assertEquals('X', mapa.getCharNasCoordenadas(coordenada));
        assertEquals('X', mapa.getCharNasCoordenadas(new Coordenada(coordenada.getLinha(), coordenada.getColuna()+1)));
        assertEquals('X', mapa.getCharNasCoordenadas(new Coordenada(coordenada.getLinha(), coordenada.getColuna()+2)));
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

        assertEquals('X', mapa.getCharNasCoordenadas(coordenada));
        assertEquals('X', mapa.getCharNasCoordenadas(new Coordenada(linha, coluna+1)));
        assertEquals('X', mapa.getCharNasCoordenadas(new Coordenada(linha, coluna+2)));
        assertEquals('X', mapa.getCharNasCoordenadas(new Coordenada(linha, coluna+3)));
    }
}
