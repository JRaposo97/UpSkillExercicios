/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

/**
 *
 * @author joaor
 */
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numeroFuncionario", "cargo"})
@JacksonXmlRootElement(localName = "funcionario")
public class FuncionarioDTO extends PessoaDTO {

    @JacksonXmlProperty(localName = "numero")
    private int numeroFuncionario;
    @JacksonXmlProperty(localName = "cargo")
    private String cargo;

    public FuncionarioDTO() {
        super();
    }
    
    public FuncionarioDTO(long nif, String nome, DataDTO nascimento, int nrFuncionario, String cargo){
        this.setNif(nif);
        this.setNome(nome);
        this.setNascimento(nascimento);
        this.setNumeroFuncionario(nrFuncionario);
        this.setCargo(cargo);
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(int numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
