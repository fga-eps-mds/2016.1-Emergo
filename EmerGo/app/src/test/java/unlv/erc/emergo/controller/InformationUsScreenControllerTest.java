package unlv.erc.emergo.controller;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.controller.InformationUsScreenController;


public class InformationUsScreenControllerTest extends TestCase{

    List<String> listOfInformations = new ArrayList<String>();
    InformationUsScreenController info = new InformationUsScreenController();

    public void testIfListAddTitle (){
        boolean result = true;
        String title = "        Informações da Unidade de Saúde";
        String titleTest =  "        Informações da Unidade de Saúde";
        listOfInformations.add(title);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(titleTest)){
            assertTrue(result);
        }else{
            assertFalse(result);
        }
    }

    public void testIfListAddNome(){

        boolean result = true;
        String name = "  Nome: ";
        String nameTest =  "  Nome: ";
        listOfInformations.add(name);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(nameTest)){
            assertTrue(result);
        }else{
            assertFalse(result);
        }
    }

    public void testIfListAddManagement(){
        boolean result = true;
        String management = "  Tipo de atendimento: " ;
        String gestaoTest =  "  Tipo de atendimento: " ;
        listOfInformations.add(management);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(gestaoTest)){
            assertTrue(result);
        }else{
            assertFalse(result);
        }
    }

    public void testIfListAddUf(){
        boolean result = true;
        String uf = "  UF: " ;
        String ufTest =  "  UF: " ;
        listOfInformations.add(uf);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(ufTest)){
            assertTrue(result);
        }else{
            assertFalse(result);
        }
    }

    public void testIfListAddDistrict(){
        boolean result = true;
        String district = "  Município: " ;
        String districtTest =  "  Município: " ;
        listOfInformations.add(district);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(districtTest)){
            assertTrue(result);
        }else{
            assertFalse(result);
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

    public void testIfListAddAddressNumber(){
        boolean result = true;
        String addressNumber = "  Bairro: ";
        String adderssNumberTest =  "  Bairro: " ;
        listOfInformations.add(addressNumber);
        int tamanho = listOfInformations.size();
        if(listOfInformations.get(tamanho -1).contentEquals(adderssNumberTest)){
            assertTrue(result);
        }else{
            assertFalse(result);
        }
    }

    public void testIfSetCep(){
        String cep = "123423";
        boolean valido = true;
        info.setCep(cep);
        if(cep.compareTo(info.getCep()) == 0){
            assertTrue(valido);
        }else{
            assertFalse(valido);
        }
    }

    public void testIfSetBairro(){
        String bairro = "Birro das flores";
        boolean valido = true;
        info.setCep(bairro);
        if(bairro.equals(info.getBairro())){
            assertTrue(valido);
        }
    }

    public void testIfSetMunicipio(){
        String municipio = "municipio";
        boolean valido = true;
        info.setMunicipio(municipio);
        if(municipio.equals(info.getMunicipio())){
            assertTrue(valido);
        }
    }

    public void testIfSetUf(){
        String uf = "unidade federativa";
        boolean valido = true;
        info.setUf(uf);
        if(uf.equals(info.getUf())){
            assertTrue(valido);
        }
    }

    public void testIfSetGestao(){
        String gestao = "gestao de negocio";
        boolean valido = true;
        info.setGestao(gestao);
        if(gestao.equals(info.getGestao())){
            assertTrue(valido);
        }
    }

    public void testIfSetNome(){
        String nome = "my name";
        boolean valido = true;
        info.setNome(nome);
        if(nome.equals(info.getNome())){
            assertTrue(valido);
        }
    }

    public void testIfSetTitulo(){
        String titulo = "o titulo";
        boolean valido = true;
        info.setTitulo(titulo);
        if(titulo.equals(info.getTitulo())){
            assertTrue(valido);
        }
    }

    public void testIfSetPadding(){
        String padding = " o padding de padding";
        boolean valido = true;
        info.setPadding(padding);
        if(padding.equals(info.getPadding())){
            assertTrue(valido);
        }
    }

}
