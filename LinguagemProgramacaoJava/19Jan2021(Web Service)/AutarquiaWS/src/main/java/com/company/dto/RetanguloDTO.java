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
import com.company.model.Rectangulo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "altura", "cumprimento"})
@JacksonXmlRootElement(localName = "rectangular")
public class RetanguloDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "altura")
    private Double altura;
    @JacksonXmlProperty(localName = "cumprimento")
    private Double cumprimento;

    public RetanguloDTO() {
    }

    public RetanguloDTO(String nome,Double altura, Double cumprimento) {
        this.nome = nome;
        this.altura = altura;
        this.cumprimento = cumprimento;
    }

    public RetanguloDTO(Rectangulo r) {
        this.nome = r.getNome();
        this.altura = r.getAltura();
        this.cumprimento = r.getCumprimento();
    }

    public Double getaltura() {
        return altura;
    }

    public void setDia(Double altura) {
        this.altura = altura;
    }

    public Double getCumprimento() {
        return cumprimento;
    }

    public void setMes(Double cumprimento) {
        this.cumprimento = cumprimento;
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
