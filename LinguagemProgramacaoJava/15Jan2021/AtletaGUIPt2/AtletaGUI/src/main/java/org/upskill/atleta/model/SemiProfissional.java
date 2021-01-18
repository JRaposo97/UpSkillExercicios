package org.upskill.atleta.model;

/**
 *
 * @author joaor
 */
public class SemiProfissional extends NaoProfissional {

    private double parcelaVariavel = getAntiguidadePercent();
    private static double parcelaFixa = 500;
    private static final double IRS = 10;

    private static int count = 0;

    public SemiProfissional(String nome, int nic, int diaNascimento, int mesNascimento, int anoNascimento, String genero, String atividade, int FCR, int diaRegisto, int mesRegisto, int anoRegisto) {
        super(nome, nic, diaNascimento, mesNascimento, anoNascimento, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto);
        
        count++;
    }
    
    public SemiProfissional(){
        super();
        count++;
    }

    /**
     * @return the parcelaFixa
     */
    public static double getParcelaFixa() {
        return parcelaFixa;
    }

    /**
     * @param aParcelaFixa the parcelaFixa to set
     */
    public static void setParcelaFixa(double aParcelaFixa) {
        parcelaFixa = aParcelaFixa;
    }

    public static int getCount() {
        return count;
    }
    
   @Override
    public double getImpostoIRS() {
        return parcelaFixa *(IRS/100);
    }

    @Override
    public double calculoPagamento() {
        parcelaFixa = parcelaFixa - getImpostoIRS();
        return (parcelaFixa + (parcelaFixa * (parcelaVariavel / 100)));
    }
    
 
    
    @Override
    public String toString(){
        return String.format("Atleta SemiProfissional"
                + "\n%s" + "Salário Base: %.1f\n" + "Valor a pagar: %.1f\n",
                super.toString(), parcelaFixa, calculoPagamento());
    }

 
  
}
