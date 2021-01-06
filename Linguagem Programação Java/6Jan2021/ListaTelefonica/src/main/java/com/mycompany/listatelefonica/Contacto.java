/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listatelefonica;

/**
 *
 * @author joaor
 */
public class Contacto {

    private String nome;
    private int telefone;
    private String email;

    private static final String NOME_OMISSO = "Sem Nome";
    private static final String EMAIL_OMISSO = "Sem Email";

    public Contacto(String nome, int telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Contacto(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = EMAIL_OMISSO;
    }

    public Contacto(int telefone, String email) {
        this.nome = NOME_OMISSO;
        this.telefone = telefone;
        this.email = email;
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
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("\n --- Contacto ---"
                + "\nNome : %s"
                + "\nNumero : %d"
                + "\nE-mail : %s\n", nome, telefone, email);
    }
}
