package com.example.leonardo.myapplication;

import com.orm.SugarRecord;

/**
 * Created by leonardo on 21/05/16.
 */
public class Contato extends SugarRecord {

    private String nome;
    private String numero;

    public Contato(){

    }
    public Contato(String nome, String numero){
        setNome(nome);
        setNumero(numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
