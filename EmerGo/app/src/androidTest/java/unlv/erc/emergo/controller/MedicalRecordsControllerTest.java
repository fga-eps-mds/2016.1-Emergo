package unlv.erc.emergo.controller;

import android.support.test.espresso.Espresso;
import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MedicalRecordsControllerTest extends ActivityInstrumentationTestCase2<MedicalRecordsController>{
    private UiDevice device;
    private MedicalRecordsController register;

    public MedicalRecordsControllerTest() {
        super(MedicalRecordsController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testSaveOption(){
        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.saveButton)).check(matches(withText("Salvar")));
    }


    public void testIfNameLabelIsCorrect(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameTextView)).check(matches(withText("Nome")));
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testNameField(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testNameFieldIsEmpty(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText(""));
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testNameFieldLessThanThree(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("Eu"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testIfDateLabelIsCorrect() {
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayTextView)).check(matches(withText("Data De Nascimento")));
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }


    public void testBirthdayField(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }


    public void testIfTypeBloodLabelIsCorrect() {
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodTextView)).check(matches(withText("Tipo Sanguíneo")));
    }


    public void testTypeBloodField(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testIfCardiacLabelIsCorrect() {
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacTextView)).check(matches(withText("Cardiaco")));
    }


    public void testCardiacFieldOptionYes(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }


    public void testCardiacFieldOptionNo(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testCardiacFieldOptionIDontKnow(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testIfDiabeticLabelIsCorrect() {
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticTextView)).check(matches(withText("Diabetico")));
    }

    public void testDiabeticFieldOptionYes(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testDiabeticFieldOptionNo(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testDiabeticFieldOptionIDontKnow(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testIfHypertensionLabelIsCorrect() {
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionTextView)).check(matches(withText("Hipertenso")));
    }

    public void testHypertensionFieldOptionYes(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testHypertensionFieldOptionNo(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testHypertensionFieldOptionIDontKnow(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testIfSeropositiveLabelIsCorrect() {
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.seropositiveTextView)).check(matches(withText("Soropositivo")));
    }

    public void testSeropositiveFieldOptionYes(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testSeropositiveFieldOptionNo(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testSeropositiveFieldOptionIDontKnow(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testObservation(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.observations)).check(matches(isDisplayed()));
        onView(withId(R.id.observationsEditText)).perform(typeText("42 = sentido da vida, o universo e tudo mais"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }

    public void testUpdateUser(){
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.observations)).check(matches(isDisplayed()));
        onView(withId(R.id.observationsEditText)).perform(typeText("42 = sentido da vida, o universo e tudo mais"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.seropositiveTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.observations)).check(matches(isDisplayed()));
        onView(withId(R.id.observationsEditText)).perform(typeText("42 = sentido da vida, o universo e tudo mais"));
        Espresso.closeSoftKeyboard();
        onView(withText("Alterar")).perform(click());
        onView(withText("Excluir")).perform(click());
    }
}
