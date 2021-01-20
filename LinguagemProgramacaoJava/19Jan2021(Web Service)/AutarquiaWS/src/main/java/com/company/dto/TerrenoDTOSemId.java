/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

/**
 *
 * @author joaor
 */
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "forma"})
@JacksonXmlRootElement(localName = "terreno")
public class TerrenoDTOSemId {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "forma")
    private FormaDTOTransformer forma;

    public TerrenoDTOSemId() {
    }

    public TerrenoDTOSemId(String nome, FormaDTOTransformer forma) {
        setNome(nome);
        setForma(forma);
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
     * @return the forma
     */
    public FormaDTOTransformer getForma() {
        return forma;
    }

    /**
     * @param forma the forma to set
     */
    public void setForma(FormaDTOTransformer forma) {
        this.forma = forma;
    }

}
