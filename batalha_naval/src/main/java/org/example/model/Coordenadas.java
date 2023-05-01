package org.example.model;

import java.util.Objects;

public class Coordenadas {
    private int coluna;
    private int linha;

    public Coordenadas(int linha, int coluna) throws ArrayIndexOutOfBoundsException{
        if (linha < 0 || linha > 9 || coluna < 0 || coluna > 9){
            throw new ArrayIndexOutOfBoundsException("Coordenada com valor inválido, passe um valor entre 0 e 9");
        }

        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenadas that)) return false;
        return getColuna() == that.getColuna() && getLinha() == that.getLinha();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColuna(), getLinha());
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }
}
