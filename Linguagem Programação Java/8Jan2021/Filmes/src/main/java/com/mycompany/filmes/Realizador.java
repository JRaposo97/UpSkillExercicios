/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmes;

/**
 *
 * @author joaor
 */
public class Realizador {

    private String nome;
    private String nacionalidade;
    private Data dataNascimento;

    private static final String NOME_OMISSO = "Sem nome";
    private static final String NACIONALIDADE_OMISSO = "Sem Nacionalidade";
    private static final Data DATANASCIMENTO_OMISSA = new Data();

    public Realizador(String nome, String nacionalidade, Data dataNascimento) throws Exception {
        setNome(nome);
        setNacionalidade(nacionalidade);
        setDataNascimento(dataNascimento);
    }

    public Realizador(){
        this.nome = NOME_OMISSO;
        this.nacionalidade = NACIONALIDADE_OMISSO;
        this.dataNascimento = DATANASCIMENTO_OMISSA;
    }

    /**
     * @return the dataNascimento
     */
    public Data getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Data dataNascimento) throws Exception {
        if (dataNascimento.getAno() < 1910) {
            throw new Exception("Duvido que tenhas mais de 110 Anos");
        }
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws Exception {
        if (nome.trim().isEmpty()) {
            throw new Exception("O nome não pode ser vazio");
        } else {
            char c;
            for (int i = 0; i < nome.length(); i++) {
                c = nome.charAt(i);
                if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                    throw new Exception("O " + nome + "tem caracteres que não são letras");
                }
            }
        }
        this.nome = nome;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) throws Exception {
        if (nacionalidade.trim().isEmpty()) {
            throw new Exception("A nacionalidade não pode ser vazia");
        } else {
            char c;
            for (int i = 0; i < nacionalidade.length(); i++) {
                c = nacionalidade.charAt(i);
                if (Character.isLetter(c) == false && Character.isSpaceChar(c) == false) {
                    throw new Exception("O " + nacionalidade + "tem caracteres que não são letras");
                }
            }
        }
        this.nacionalidade = nacionalidade;
    }

}
