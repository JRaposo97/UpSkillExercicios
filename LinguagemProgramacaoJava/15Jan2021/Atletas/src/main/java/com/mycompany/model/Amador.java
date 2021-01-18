package com.mycompany.model;

/**
 *
 * @author joaor
 */
public class Amador extends NaoProfissional {

    private static double parcela2 = 7;

    private static int count = 0;

    private static int minimo = 5;

    public Amador(String nome, int nic, int diaNascimento, int mesNascimento, int anoNascimento, String genero, String atividade, int FCR, int diaRegisto, int mesRegisto, int anoRegisto) {
        super(nome, nic, diaNascimento, mesNascimento, anoNascimento, genero, atividade, FCR, diaRegisto, mesRegisto, anoRegisto);
        count++;
    }
    
    public Amador(){
        super();
        count++;
    }

    /**
     * @return the parcela2
     */
    public static double getParcela2() {
        return parcela2;
    }

    /**
     * @param aParcela2 the parcela2 to set
     */
    public static void setParcela2(double aParcela2) {
        parcela2 = aParcela2;
    }

    public static int getCount() {
        return count;
    }

    /**
     * @return the minimo
     */
    public static int getMinimo() {
        return minimo;
    }

    /**
     * @param aMinimo the minimo to set
     */
    public static void setMinimo(int aMinimo) {
        minimo = aMinimo;
    }

    @Override
    public double getImpostoIRS() {
        return 0;
    }

    @Override
    public double calculoPagamento() {
        double pagamento;

        pagamento = ((getValorMensalArrecadado() * (getAntiguidadePercent() / 100)) + (getValorMensalArrecadado() * (parcela2 / 100)));

        if (pagamento < minimo) {
            return minimo;
        } else {
            return pagamento;
        }

    }

    @Override
    public String toString(){
        return String.format("Atleta Amador\n%s" + "Valor a pagar: %.1f\n",
                super.toString(), calculoPagamento());
    }

}
