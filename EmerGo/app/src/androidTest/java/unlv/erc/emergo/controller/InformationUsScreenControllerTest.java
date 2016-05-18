package unlv.erc.emergo.controller;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 04/05/16.
 */
public class InformationUsScreenControllerTest extends TestCase{

    List<String> listOfInformations = new ArrayList<String>();

    public void testIfListAddTitulo(){
        boolean resultado = true;
        String titulo = "        Informações da Unidade de Saúde";
        String tituloTest =  "        Informações da Unidade de Saúde";
        listOfInformations.add(titulo);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(tituloTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }

    }

    public void testIfListAddNome(){

        boolean resultado = true;
        String nome = "  Nome: ";
        String nomeTest =  "  Nome: ";
        listOfInformations.add(nome);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(nomeTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }
    }

    public void testIfListAddGestao(){
        boolean resultado = true;
        String gestao = "  Tipo de atendimento: " ;
        String gestaoTest =  "  Tipo de atendimento: " ;
        listOfInformations.add(gestao);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(gestaoTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }

    }

    public void testIfListAddUf(){
        boolean resultado = true;
        String uf = "  UF: " ;
        String ufTest =  "  UF: " ;
        listOfInformations.add(uf);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(ufTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }
    }

    public void testIfListAddMunicipio(){
        boolean resultado = true;
        String municipio = "  Município: " ;
        String municipioTest =  "  Município: " ;
        listOfInformations.add(municipio);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(municipioTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }

    }

    public void testIfListAddBairro(){
        boolean resultado = true;
        String bairro = "  Bairro: ";
        String bairroTest =  "  Bairro: " ;
        listOfInformations.add(bairro);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(bairroTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }

    }

    public void testIfListAddCep(){
        boolean resultado = true;
        String cep = "  Bairro: ";
        String cepTest =  "  Bairro: " ;
        listOfInformations.add(cep);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(cepTest)){
            assertTrue(resultado);
        }else{
            assertFalse(resultado);
        }

    }
}
