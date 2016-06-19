package unlv.erc.emergo.controller;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class InformationUsScreenControllerTest extends TestCase{

=======
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
>>>>>>> estoriaTracarRota
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
