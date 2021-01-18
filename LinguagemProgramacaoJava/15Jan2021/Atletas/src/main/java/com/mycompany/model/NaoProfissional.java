package com.mycompany.model;

import java.util.Calendar;

/**
 *
 * @author joaor
 */
abstract public class NaoProfissional extends Atleta {

    Calendar now = Calendar.getInstance();
    
    private int antiguidade = (now.get(Calendar.YEAR) - getDataRegisto().get(Calendar.YEAR));
    
    private static double ANTIGUIDADEPERCENT1 = 2;
    private static double ANTIGUIDADEPERCENT2 = 8;
    private static double ANTIGUIDADEPERCENT3 = 20;
    

    public NaoProfissional(String nome, int nic, int diaNascimento, int mesNascimento, int anoNascimento, String genero, String atividade, int FCR, int diaRegisto, int mesRegisto, int anoRegisto) {
        super(nome, nic, diaNascimento, mesNascimento, anoNascimento, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto);
    }
    
    public NaoProfissional(){
        super();
    }

    /**
     * @return the antiguidade
     */
    public int getAntiguidade() {
        return antiguidade;
    }

    /**
     * @param antiguidade the antiguidade to set
     */
    public void setAntiguidade(int antiguidade) {
        this.antiguidade = antiguidade;
    }

    /**
     * @return the ANTIGUIDADEPERCENT1
     */
    public static double getANTIGUIDADEPERCENT1() {
        return ANTIGUIDADEPERCENT1;
    }

    /**
     * @param aANTIGUIDADEPERCENT1 the ANTIGUIDADEPERCENT1 to set
     */
    public static void setANTIGUIDADEPERCENT1(double aANTIGUIDADEPERCENT1) {
        ANTIGUIDADEPERCENT1 = aANTIGUIDADEPERCENT1;
    }

    /**
     * @return the ANTIGUIDADEPERCENT2
     */
    public static double getANTIGUIDADEPERCENT2() {
        return ANTIGUIDADEPERCENT2;
    }

    /**
     * @param aANTIGUIDADEPERCENT2 the ANTIGUIDADEPERCENT2 to set
     */
    public static void setANTIGUIDADEPERCENT2(double aANTIGUIDADEPERCENT2) {
        ANTIGUIDADEPERCENT2 = aANTIGUIDADEPERCENT2;
    }

    /**
     * @return the ANTIGUIDADEPERCENT3
     */
    public static double getANTIGUIDADEPERCENT3() {
        return ANTIGUIDADEPERCENT3;
    }

    /**
     * @param aANTIGUIDADEPERCENT3 the ANTIGUIDADEPERCENT3 to set
     */
    public static void setANTIGUIDADEPERCENT3(double aANTIGUIDADEPERCENT3) {
        ANTIGUIDADEPERCENT3 = aANTIGUIDADEPERCENT3;
    }
    
    public double getAntiguidadePercent(){
        double antiguidadePercent = 0;
        if(antiguidade>=5 && antiguidade<=10){
            antiguidadePercent = ANTIGUIDADEPERCENT1 ;
        }else if(antiguidade>10 && antiguidade<=20){
             antiguidadePercent = ANTIGUIDADEPERCENT2 ;
        }else if (antiguidade>20){
             antiguidadePercent = ANTIGUIDADEPERCENT3 ;
        }
        
        return antiguidadePercent;
    }
    

     @Override
    // a assinatura deste método obriga a ser Object
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        //se receber um objecto nulo ou uma classe sem parametros
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        //são dois objectos do mesmo tipo e não são o mesmo objecto
        NaoProfissional np = (NaoProfissional) outroObjeto;
        return this.antiguidade == np.getAntiguidade(); 
    }
    
     @Override
    public String toString(){
        return String.format("%s"  + "Antiguidade: %d\n",
                super.toString(), getAntiguidade());
    }
    
    
}
