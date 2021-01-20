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

@JsonPropertyOrder({"altura", "cumprimento"})
@JacksonXmlRootElement(localName = "rectangulo")
public class RetanguloDTO {
    
    @JacksonXmlProperty(localName = "altura")
    private Double altura;
    @JacksonXmlProperty(localName = "cumprimento")
    private Double cumprimento;

    public RetanguloDTO() {
    }

    public RetanguloDTO(Double altura, Double cumprimento) {
        this.altura = altura;
        this.cumprimento = cumprimento;
    }

    public RetanguloDTO(Rectangulo r) {
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

}
