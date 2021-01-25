/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.company.model.Pessoa;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */

@JacksonXmlRootElement(localName = "proprietarios")
public class ListaProprietarioDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "proprietario")

    private ArrayList<Pessoa> proprietarios;

    public ListaProprietarioDTO() {
    }

    public ArrayList<Pessoa> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(ArrayList<Pessoa> proprietarios) {
        this.proprietarios = proprietarios;
    }

}
