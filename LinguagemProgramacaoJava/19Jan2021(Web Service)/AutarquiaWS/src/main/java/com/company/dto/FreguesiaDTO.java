/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nomeFreguesia"})
@JacksonXmlRootElement(localName = "freguesia")
public class FreguesiaDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nomeFreguesia;

    public FreguesiaDTO() {
    }

    public String getNomeFreguesia() {
        return nomeFreguesia;
    }

    public void setNif(String nomeFreguesia) {
        this.nomeFreguesia = nomeFreguesia;
    }

}
