package com.example.leonardo.myapplication;

import java.util.ArrayList;

/**
 * Created by leonardo on 21/05/16.
 */
public class Contatos {

    private ArrayList<Contato> contatos;

    public Contatos(){

    }

    public Contatos(ArrayList<Contato> contatos){
        setContatos(contatos);
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
}
