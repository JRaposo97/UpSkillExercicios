package org.upskill.atleta.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author diana
 */
abstract public class Atleta implements Atividade, Genero, Comparable<Atleta> {

    /**
     * declaração de variáveis
     */
    
    private String nome;
    private int nic;
    private Calendar dataNascimento;
    private String genero;
    private String atividade;
    private Calendar dataRegisto;
    private int FCR;
    private double valorMensalArrecadado = 0;

    /**
     * declaração e inicialização de variáveis
     */
    public static final double intensidadeTreinoQueimaGordura = 0.6;
    public static final double intensidadeTreinoCardiorespiratoria = 0.75;

    private static final String NOME_OMISSO = "Sem Nome";
    private static final int NIC_OMISSO = 0000000000;
    private static final Calendar DATANASCIMENTO_OMISSO = Calendar.getInstance();
    private static final String GENERO_OMISSO = "Não Tem Genero";
    private static final String ATIVIDADE_OMISSA = "Não Tem Atividade";
    private static final Calendar DATAREGISTO_OMISSO = Calendar.getInstance();
    private static final int FCR_OMISSO = 0;

    /**
     * construtor para atribuir variáveis com os valores de entrada
     * 
     * @param nome , nome do atleta
     * @param nic , número de identificação civil do atleta
     * @param diaNascimento , dia de nascimento do atleta
     * @param mesNascimento , mês de nascimento do atleta
     * @param anoNascimento , ano de nascimento do atleta
     * @param genero , género do atleta, Masculino ou Feminino
     * @param atividade , atividade do atleta: caminhada, corrida, ciclismo ou natação
     * @param FCR , Frêquencia Cardiaca em Repouso
     * @param mesRegisto , mês de registo no clube, do atleta
     * @param anoRegisto, ano de registo no clube, do atleta
     * @param diaRegisto , ano de registo no clube, do atleta
     */
    public Atleta(String nome, int nic, int diaNascimento, int mesNascimento, int anoNascimento, String genero, String atividade, int FCR, int diaRegisto, int mesRegisto, int anoRegisto) {
        this.nome = nome;
        this.nic = nic;
        this.genero = genero;
        this.atividade = atividade;
        this.FCR = FCR;

        this.dataNascimento = Calendar.getInstance();

        dataNascimento.set(anoNascimento, mesNascimento - 1, diaNascimento);

        this.dataRegisto = Calendar.getInstance();

        dataRegisto.set(anoRegisto, mesRegisto - 1, diaRegisto);
    }

    /**
     * construtor vazio para atribuir variáveis por omissão
     */
    public Atleta() {
        this.nome = NOME_OMISSO;
        this.nic = NIC_OMISSO;
        this.genero = GENERO_OMISSO;
        this.atividade = ATIVIDADE_OMISSA;
        this.FCR = FCR_OMISSO;

        this.dataNascimento = DATANASCIMENTO_OMISSO;
        this.dataRegisto = DATAREGISTO_OMISSO;
    }

    /**
     * reformatação das Strings DateFormat
     * @return da descrição do objecto
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // declaração de um objecto do tipo "formato de Data" com o formato apresentado

        String formattedNascimento = dateFormat.format(dataNascimento.getTime());
        String formattedRegisto = dateFormat.format(dataRegisto.getTime());

        return String.format("Atleta: %s\n" + "Genero: %s\n" + "Data de Nascimento: %s\n" + "NIC: %s\n" + "Modalidade: %s\n" + "Batimento Cardíaco em Repouso: %s\n" + "Data de registo: %s\n" + "ValorArrecadado : %.1f\n",
                nome, genero, formattedNascimento, nic, atividade, FCR, formattedRegisto, valorMensalArrecadado);

    }

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome método para alterar o nome de uma instância Atleta
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return nic método para ver o número de identificação civil de um atleta
     */
    public int getNic() {
        return nic;
    }

    /**
     * @param nic 
     * método para alterar o número de identificação civil de um atleta
     */
    public void setNic(int nic) {
        this.nic = nic;
    }

    /**
     * @return dataNascimento
     */
    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param Dia , dia de nascimento do atleta
     * @param Mes , mês de nascimento do atleta
     * @param Ano , ano de nascimento do atleta
     */
    public void setDataNascimento(int Dia, int Mes, int Ano) {
        dataNascimento.set(Ano, Mes - 1, Dia);
    }

    /**
     * @return genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return atividade
     */
    public String getAtividade() {
        return atividade;
    }

    /**
     * @param atividade the atividade to set
     */
    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    /**
     * @return FCR
     */
    public int getFCR() {
        return FCR;
    }

    /**
     * @param FCR the FCR to set
     */
    public void setFCR(int FCR) {
        this.FCR = FCR;
    }

    /**
     * @return valorMensalArrecadado de prémios que um atleta recebe em cada mês
     */
    public double getValorMensalArrecadado() {
        return valorMensalArrecadado;
    }

    /**
     * @param aValorMensalArrecadado the valorMensalArrecadado to set
     */
    public void setValorMensalArrecadado(double aValorMensalArrecadado) {
        valorMensalArrecadado = aValorMensalArrecadado;
    }

    /**
     * @return dataRegisto
     */
    public Calendar getDataRegisto() {
        return dataRegisto;
    }

    /**
     * @param Dia , define o dia da data de registo
     * @param Mes , define o mês da data de registo
     * @param Ano , define o ano de registo 
     */
    public void setDataRegisto(int Dia, int Mes, int Ano) {
        dataRegisto.set(Ano, Mes - 1, Dia);
    }

    /**
     * @param premio
     * adiciona prémios ao valor mensal arrecadado 
     */
    public void adicionarPremio(double premio) {
        valorMensalArrecadado += premio;
    }

    /**
     * @return FCM , Frêquencia Cardiaca Máxima
     *
     * cálculo do FCM de acordo com a tabela do enunciado
     */
    public double calculoFCM() {
        
        Calendar now = Calendar.getInstance();
        int idade = now.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); //determinar a idade do atleta
        double FCM = 0;

        if (atividade.equalsIgnoreCase(Atividade.CAMINHADA) || atividade.equalsIgnoreCase(Atividade.CORRIDA)) {
            FCM = (208.75 - (0.73 * idade));
        } else if (atividade.equalsIgnoreCase(Atividade.CICLISMO)) {

            if (genero.equalsIgnoreCase(Genero.MASCULINO)) {
                FCM = (202 - (0.72 * idade));
            } else {
                FCM = (189 - (0.56 * idade));
            }
        } else if (atividade.equalsIgnoreCase(Atividade.NATACAO)) {
            FCM = (204 - (1.7 * idade));
        }
        return FCM;
        
    }

    /**
     * @return FCT , Frêquencia Cardiaca de Trabalho quando o objectivo é
     * queimar gordura
     *
     * cálculo do FCT de acordo com a fórmula do enunciado
     * FCT = FCR + [IT * (FCM - FCR)]
     */
    public double calculoFCTQueimaGordura() {
        double FCT = FCR + (intensidadeTreinoQueimaGordura * (calculoFCM() - FCR));
        return FCT;
    }

    /**
     * @return cálculo FCT , Frêquencia Cardiaca de Trabalho quando o objectivo
     * é trabalhar a capacidade cardiorespiratória
     *
     * cálculo do FCT de acordo com a fórmula do enunciado
     * FCT = FCR + [IT * (FCM - FCR)]
     */
    public double calculoFCTCardiorespiratoria() {
        return (FCR + (intensidadeTreinoCardiorespiratoria * (calculoFCM() - FCR)));
    }

    /**
     * instanciamento da função calculoPagamento()
     * @return do calculo de Pagamento
     */
    abstract public double calculoPagamento();

    /**
     * instanciamento da função getImpostoIRS()
     * @return do IRS de 10%
     */
    abstract public double getImpostoIRS();

    /**
     * @param outro , objecto da classe Atleta
     *
     * função de comparação que retorna um valor para o método sort
     *
     * @return do valor de comparação entre dois atletas por nome 
     * -1 antecede 
     * 0 é igual 
     * 1 sucede
     */
    @Override
    public int compareTo(Atleta outro) {
        return nome.compareTo(outro.getNome());
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
        Atleta outroAtleta = (Atleta) outroObjeto;
        return (this.getNome().equalsIgnoreCase(outroAtleta.getNome()) && 
                this.getNic() == outroAtleta.getNic() &&
                this.getDataNascimento().equals(outroAtleta.getDataNascimento())  &&
                this.getGenero().equalsIgnoreCase(outroAtleta.getGenero()) &&
                this.getAtividade().equalsIgnoreCase(outroAtleta.getAtividade()) &&
                this.getFCR() == outroAtleta.getFCR() &&
                this.getDataRegisto().equals(outroAtleta.getDataRegisto()) &&
                this.valorMensalArrecadado == outroAtleta.valorMensalArrecadado);
    }

}
