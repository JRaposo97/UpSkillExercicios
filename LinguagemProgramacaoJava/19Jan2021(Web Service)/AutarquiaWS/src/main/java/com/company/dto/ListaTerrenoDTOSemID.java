/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

/**
 *
 * @author joaor
 */
@JacksonXmlRootElement(localName = "terrenos")
public class ListaTerrenoDTOSemID {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "terrenos")
    private ArrayList<TerrenoDTOSemId> terrenos;

    public ListaTerrenoDTOSemID() {
    }

    public ArrayList<TerrenoDTOSemId> getTerrenos() {
        return terrenos;
    }

    public void setFreguesias(ArrayList<TerrenoDTOSemId> terrenos) {
        this.terrenos = terrenos;
    }
}
