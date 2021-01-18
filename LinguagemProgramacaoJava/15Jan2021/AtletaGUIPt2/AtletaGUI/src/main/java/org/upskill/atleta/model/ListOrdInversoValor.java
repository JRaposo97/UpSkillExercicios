package org.upskill.atleta.model;

import java.util.Comparator;

/**
 *
 * @author joaor
 */
public class ListOrdInversoValor implements Comparator<Atleta> {

    /**
     * @param o1, o2 objectos do tipo atleta
     * 
     * @return do valor de comparação dos valores mensais
     * 
     * -1 antecede
     * 0 é igual
     * 1 sucede
     */
    @Override
    public int compare(Atleta o1, Atleta o2) {
        if (o1.getValorMensalArrecadado() < o2.getValorMensalArrecadado()) {
            return 1;
        }
        if (o1.getValorMensalArrecadado() > o2.getValorMensalArrecadado()) {
            return -1;
        }
        return 0;
    }

}
