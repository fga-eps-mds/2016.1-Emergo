package unlv.erc.emergo.controller;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class InformationUsScreenControllerTest extends TestCase{

    List<String> listOfInformations = new ArrayList<>();

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
}
