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
public class ListaTerrenoDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "terrenos")
    private ArrayList<Object> terrenos;

    public ListaTerrenoDTO() {
    }

    public ArrayList<Object> getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(ArrayList<Object> terrenos) {
        this.terrenos = terrenos;
    }
}
