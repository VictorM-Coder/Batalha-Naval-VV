package org.example.model;

import org.example.enums.Position;
import org.example.enums.StatusTiro;
import org.example.exception.CoordenadaInvalidaException;
import org.example.model.barco.factory.BarcoFactory;
import org.example.model.barco.factory.RebocadorFactory;
import org.example.model.barco.factory.SubmarinoFactory;
import org.example.model.coordenada.Coordenada;
import org.example.model.matriz.Matriz;
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
    public void disparar_Deve_Retornar_Tiro_Na_Agua_Quando_O_Tiro_Nao_Acertar_Nada(){
        Coordenada coordenada = new Coordenada(0, 9);

        StatusTiro status = this.matriz.disparar(coordenada);

        assertEquals(StatusTiro.TIRO_NA_AGUA, status);
        assertEquals('*', this.matriz.getCharNasCoordenadas(coordenada));
    }

    @Test
    public void Uma_Matriz_Deve_Ter_Dez_Linhas_E_Dez_Colunas_Ao_Ser_Iniciada(){
        //Ação
        char[][] campo = matriz.getMapa();

        //Asserção
        assertEquals(10, campo.length);
        assertEquals(10, campo[0].length);
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
    public void alocarBarco_Deve_Colocar_Um_Barco_Nas_Coordenadas_Definidas(){
        final Coordenada coordenada = new Coordenada(0, 9);

        matriz.alocarBarco((new SubmarinoFactory()).criarNovoBarco(), coordenada, Position.HORIZONTAL);

        assertEquals('X', matriz.getCharNasCoordenadas(coordenada));
    }

    @Test
    public void alocarBarco_Deve_Lancar_CoordenadaInvalidaException_Quando_Aquela_Coordenada_Ja_Estiver_Ocupada(){
        final int coluna = 9, linha = 0;
        final Coordenada coordenada = new Coordenada(linha, coluna);
        BarcoFactory factory = new SubmarinoFactory();
        matriz.alocarBarco(factory.criarNovoBarco(), coordenada, Position.HORIZONTAL);

        CoordenadaInvalidaException exception = assertThrows(CoordenadaInvalidaException.class, () -> matriz.alocarBarco(factory.criarNovoBarco(), coordenada, Position.HORIZONTAL));
        assertEquals("as coordenada passadas são inválidas, tente um intervalo livre", exception.getMessage());
    }

    @Test
    public void alocarBarco_Deve_Lancar_CoordenadaInvalidaException_Quando_Um_Parte_Do_Barco_Tentar_Ocupar_Coordenada_Ja_Ocupada(){
        BarcoFactory factory = new RebocadorFactory();
        matriz.alocarBarco(factory.criarNovoBarco(), new Coordenada(0,1), Position.HORIZONTAL);

        CoordenadaInvalidaException exception = assertThrows(CoordenadaInvalidaException.class, () -> matriz.alocarBarco(factory.criarNovoBarco(), new Coordenada(0, 0), Position.HORIZONTAL));
        assertEquals("as coordenada passadas são inválidas, tente um intervalo livre", exception.getMessage());
    }
}
