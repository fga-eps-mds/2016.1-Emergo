package unlv.erc.emergo.controller;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by leonardo on 04/05/16.
 */
public class InformationUsScreenControllerTest  extends ActivityInstrumentationTestCase2<InformationUsScreenController> {
    List<String> listOfInformations = new ArrayList<String>();
    InformationUsScreenController information = new InformationUsScreenController();

    public InformationUsScreenControllerTest(){
        super(InformationUsScreenController.class);
    }

    @Before
    public void setUp() throws  Exception{
        super.setUp();
        getActivity();
    }

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

    public void testButtonTracarRotaIsClickable(){
        Button tracar = (Button) information.findViewById(R.id.botaoRota);
        boolean valido = true;
        if (tracar.isClickable()){
            assertTrue(valido);
        }else{
            assertFalse(valido);
        }
    }

    public void testButtonIsVisible(){
        onView(withId(R.id.botaoRota)).check(matches(isDisplayed()));
        onView(withText("Traçar Rota")).perform(click());
        onView(withId(R.id.botaoRota)).check(matches(withText("Traçar Rota")));
    }

    public void testIfLabelIsCorrect(){
        onView(withId(R.id.botaoRota)).check(matches(isDisplayed()));
        onView(withText("Traçar Rota")).perform(click());
    }

}
