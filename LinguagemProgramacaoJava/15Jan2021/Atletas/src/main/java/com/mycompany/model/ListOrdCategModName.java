package com.mycompany.model;

import java.util.Comparator;

/**
 *
 * @author joaor
 */
public class ListOrdCategModName implements Comparator<Atleta> {

    /**
     * @param o1,o2 dois objectos do tipo atleta
     *
     * @return do valor de comparação entre dois atletas, 
     * por categoria, modalidade e nome
     *
     * -1 antecede 
     * 0 é igual 
     * 1 sucede
     */
    @Override
    public int compare(Atleta o1, Atleta o2) {
        if (o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName()) > 0) {
            return 1;
        }
        if (o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName()) < 0) {
            return -1;
        } else {
            if (o1.getAtividade().compareTo(o2.getAtividade()) > 0) {
                return 1;
            } else if (o1.getAtividade().compareTo(o2.getAtividade()) < 0) {
                return -1;
            } else {
                return o1.getNome().compareTo(o2.getNome());
            }
        }
    }

}
