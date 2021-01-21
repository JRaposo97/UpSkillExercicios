/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.company.model.Triangulo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "base", "altura"})
@JacksonXmlRootElement(localName = "triangular")
public class TrianguloDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "base")
    private Double base;
    @JacksonXmlProperty(localName = "altura")
    private Double altura;

    public TrianguloDTO() {
    }

    public TrianguloDTO(String nome, Double base, Double altura) {
        this.nome = nome;
        this.base = base;
        this.altura = altura;
    }

    TrianguloDTO(Triangulo t) {
        this.nome = t.getNome();
        this.base = t.getBase();
        this.altura = t.getAltura();
    }

    /**
     * @return the base
     */
    public Double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(Double base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public Double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Double altura) {
        this.altura = altura;
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
}
