
package org.upskill.matrizgenerica.main;

import java.util.ArrayList;
import java.util.List;
import org.upskill.matrizgenerica.model.MatrizGenerica;
import org.upskill.matrizgenerica.model.Trabalhador;
import org.upskill.matrizgenerica.model.TrabalhadorPeca;

public class MainMatrizGenerica {

    public static void main(String[] args) {
        
        
        MatrizGenerica<String> matStrings= new MatrizGenerica();
        MatrizGenerica<Comparable> matComparable = new MatrizGenerica();
        
        MatrizGenerica<TrabalhadorPeca> matTPecas = new MatrizGenerica();
        MatrizGenerica<Trabalhador> matTrabalhadores = new MatrizGenerica();
        
        List<TrabalhadorPeca> listaTP = new ArrayList<>();
        
        TrabalhadorPeca tp1 = new TrabalhadorPeca("Jose", 10, 20);
        
        listaTP.add(tp1);
        
        matTrabalhadores.addLine(listaTP);
    }
    
}
