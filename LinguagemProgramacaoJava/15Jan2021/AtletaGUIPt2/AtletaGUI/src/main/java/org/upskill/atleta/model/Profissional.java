package org.upskill.atleta.model;

/**
 *
 * @author joaor
 */
public class Profissional extends Atleta{
    
    private double parcelaFixa;
    
    private static double parcelaVariavel = 20;
    private static final double IRS = 10;
    
    private static int count = 0;
    
    private static final double PARCELAFIXA_OMISSA = 0;
    
    
    public Profissional (String nome, int nic, int dia, int mes, int ano, String genero, String atividade, int FCR,int diaRegisto, int mesRegisto, int anoRegisto, double parcelaFixa){
        super(nome, nic, dia, mes, ano, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto);
        this.parcelaFixa = parcelaFixa;
        count++;
    }
    
    public Profissional(){
        super();
        this.parcelaFixa = PARCELAFIXA_OMISSA;
        count++;
    }

    /**
     * @return the parcelaFixa
     */
    public double getParcelaFixa() {
        return parcelaFixa;
    }

    /**
     * @param parcelaFixa the parcelaFixa to set
     */
    public void setParcelaFixa(double parcelaFixa) {
        this.parcelaFixa = parcelaFixa;
    }

    /**
     * @return the parcelaVariavel
     */
    public static double getParcelaVariavel() {
        return parcelaVariavel;
    }

    /**
     * @param aParcelaVariavel the parcelaVariavel to set
     */
    public static void setParcelaVariavel(double aParcelaVariavel) {
        parcelaVariavel = aParcelaVariavel;
    }
    
        /**
     * @return the count
     */
    public static int getCount() {
        return count;
    }
    
     @Override
    public double getImpostoIRS() {
       return parcelaFixa * (IRS/100);
    }


    @Override
    public double calculoPagamento() {
           return (parcelaFixa + (getValorMensalArrecadado() * (parcelaVariavel/100)));
    }
    
    /**
     * @return do valor de comparação verdadeiro ou falso
     * reescrita do método equals
     */
    @Override
    public boolean equals(Object outroObjeto) {
        //vê se é o mesmo tipo de objecto
        if (!super.equals(outroObjeto)) {
            return false;
        }
        //completar com a informação da subClass
        Profissional p = (Profissional) outroObjeto;
        return this.parcelaFixa == p.getParcelaFixa();
    }
    
    public String toString(){
        return String.format("Atleta Profissional\n%s" + "Salário Base: %.1f€\n" + "Valor a pagar mensalmente: %.1f€\n",
                super.toString(), parcelaFixa, calculoPagamento());
    }

   

}
