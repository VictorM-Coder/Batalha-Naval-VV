package org.example.model;

import org.example.model.coordenada.Coordenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordenadaTeste {
    @Test
    void New_Coordenada_Deve_Lancar_ArrayIndexOutOfBoundsException_Quando_Um_Valor_De_Coluna_Ou_Linha_For_Menor_Do_Que_Zero_Ou_Maior_Do_Que_Nove(){
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> new Coordenada(-1, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> new Coordenada(0, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> new Coordenada(9, 10));
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> new Coordenada(10, 9));
    }
}
