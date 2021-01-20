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

@JsonPropertyOrder({"raio"})
@JacksonXmlRootElement(localName = "circulo")
public class CirculoDTO {
    
    
    @JacksonXmlProperty(localName = "raio")
    private Double raio;
 

    public CirculoDTO() {
    }
    
    public CirculoDTO(Circulo c){
        this.raio = c.getRaio();
    }

    public CirculoDTO(Double raio) {
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

}
