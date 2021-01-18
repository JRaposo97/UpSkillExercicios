package org.upskill.matrizgenerica.model;

import java.util.ArrayList;
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

    private boolean addLine(List<E> a) {
        if(a.size() > numeroMaximoColunas){
            this.numeroMaximoColunas = a.size();
        }
        return matrizGenerica.add(a);
    }

    private boolean verifyElem(E elem) {
        boolean flag = false;
        for (int i = 0; i < matrizGenerica.size(); i++) {
            for (int j = 0; j < matrizGenerica.get(i).size(); j++) {
                if (matrizGenerica.get(i).get(j).equals(elem)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean subElem(int nrLinha, int nrColuna, E elem) {
        try {
            verificarIndices(nrLinha, nrColuna);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
        return matrizGenerica.set((matrizGenerica.get(nrLinha).get(nrColuna)), elem);
    }

    public <E> void removeLine(int nrLinha) {
        try {
            verificarIndiceLinha(nrLinha);
            matrizGenerica.remove(nrLinha);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    public E[] returnColuna(int nrColuna) {
        List<E> arr = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < matrizGenerica.size(); i++) {
            arr.add(matrizGenerica.get(i).get(nrColuna));
            count++;
        }
        E[] array = (E[])new Object[count][];
        
        array = arr.toArray(array);
        
        return array;
    }

}
