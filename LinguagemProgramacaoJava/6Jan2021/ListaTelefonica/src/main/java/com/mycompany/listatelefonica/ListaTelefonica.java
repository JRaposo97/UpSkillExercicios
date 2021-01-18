/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listatelefonica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaor
 */
public class ListaTelefonica {

    private List<Contacto> listaContactos;

    public ListaTelefonica(ArrayList<Contacto> listaContactos) {
        this.listaContactos = new ArrayList<Contacto>(listaContactos);
    }

    public ListaTelefonica() {
        this.listaContactos = new ArrayList<Contacto>();
    }

    /**
     * @return the listaContactos
     */
    public List<Contacto> getListaContactos() {
        return new ArrayList<Contacto>(this.listaContactos);
    }

    /**
     * @param listaContactos the listaContactos to set
     */
    public void setListaContactos(List<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public boolean novoContacto(Contacto contacto) {
        return listaContactos.contains(contacto) ? false : listaContactos.add(contacto);
    }

    public boolean addTresContactos(Contacto contacto1, Contacto contacto2, Contacto contacto3) {
        if (listaContactos.contains(contacto1) && listaContactos.contains(contacto2) && listaContactos.contains(contacto3)) {
            return false;
        } else {
            listaContactos.add(contacto1);
            listaContactos.add(contacto2);
            listaContactos.add(contacto3);
            typeContacts(contacto1,contacto2,contacto3);
            return true;
        }
    }

    private void typeContacts(Contacto contacto1, Contacto contacto2, Contacto contacto3) {
        System.out.println(contacto1);
        System.out.println(contacto2);
        System.out.println(contacto3);
    }

}
