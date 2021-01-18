package org.upskill.matrizgenerica.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatrizGenerica<E> {

    private List<List<E>> matrizGenerica;
    private int numeroMaximoColunas;

    public MatrizGenerica() {
        this.matrizGenerica = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    public int getNumeroDeLinhas() {
        return this.matrizGenerica.size();
    }

    public int getNumeroDeColunas(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matrizGenerica.get(indiceLinha).size();
    }

    public void limpar() {
        this.matrizGenerica.clear();
    }

    private int tamanhoColuna(int indice) {
        verificarIndiceColuna(indice);
        int numeroLinhas = 0;
        for (List<E> linha : this.matrizGenerica) {
            if (indice < linha.size()) {
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }

    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matrizGenerica.size()) {
            throw new IndexOutOfBoundsException(
                    "Índice Linha: " + indice
                    + ", Tamanho: " + this.matrizGenerica.size());
        }
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(
                    " Índice Coluna: " + indiceColuna
                    + ", Tamanho: " + this.numeroMaximoColunas);
        }
    }

    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0
                || indiceLinha >= this.matrizGenerica.size()
                || indiceColuna < 0
                || indiceColuna >= this.matrizGenerica.get(indiceLinha).size()) {
            String mensagem = mensagemIndiceLinhaInvalido(indiceLinha)
                    + mensagemIndiceColunaInvalido(indiceLinha);
            throw new IndexOutOfBoundsException(mensagem);
        }
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Índice Linha: " + indice
                + ", Tamanho: " + this.matrizGenerica.size();
    }

    private String mensagemIndiceColunaInvalido(int indice) {
        return " Índice Coluna: " + indice
                + ", Tamanho: " + this.matrizGenerica.get(indice).size();
    }

    public <E> E getElem(int indiceLinha, int indiceColuna) {
        try {
            verificarIndices(indiceLinha, indiceColuna);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }

        return (E) matrizGenerica.get(indiceLinha).get(indiceColuna);
    }

    public boolean addLine(Collection<? extends E> a) {
        if (a.size() > numeroMaximoColunas) {
            this.numeroMaximoColunas = a.size();
        }
        return matrizGenerica.add(new ArrayList<>(a));
    }

    public boolean verifyElem(E elem) {

        for (List<E> linha : matrizGenerica) {
            if (linha.contains(elem)) {
                return true;
            }
        }
        return false;
    }

    public void subElem(int nrLinha, int nrColuna, E elem) {
        try {
            verificarIndices(nrLinha, nrColuna);
            matrizGenerica.get(nrLinha).set(nrColuna, elem);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }

    }

    public List<E> removeLine(int nrLinha) {

        verificarIndiceLinha(nrLinha);
        int nrColunas = getNumeroDeColunas(nrLinha);
        List<E> lista = matrizGenerica.remove(nrLinha);

        if (nrColunas == numeroMaximoColunas) {
            for (int i = 0; i < getNumeroDeLinhas(); i++) {
                if (getNumeroDeColunas(i) > numeroMaximoColunas) {
                    numeroMaximoColunas = getNumeroDeColunas(i);
                }

            }
        }

        return lista;
    }

    public E[] returnColuna(int nrColuna) {
        List<E> arr = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < matrizGenerica.size(); i++) {
            if (matrizGenerica.size() < nrColuna) {
                arr.add(matrizGenerica.get(i).get(nrColuna));
                count++;
            }
        }
        E[] array = (E[]) new Object[count][];

        array = arr.toArray(array);

        return array;
    }
}
