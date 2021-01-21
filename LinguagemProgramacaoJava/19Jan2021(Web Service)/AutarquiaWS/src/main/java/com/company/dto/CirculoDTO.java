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
import com.company.model.Circulo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "raio"})
@JacksonXmlRootElement(localName = "circular")
public class CirculoDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "raio")
    private Double raio;

    public CirculoDTO() {
    }
    
    public CirculoDTO(String nome, Double raio){
        this.nome = nome;
        this.raio = raio;
    }

    public CirculoDTO(Circulo c) {
        this.nome = c.getNome();
        this.raio = c.getRaio();
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
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
