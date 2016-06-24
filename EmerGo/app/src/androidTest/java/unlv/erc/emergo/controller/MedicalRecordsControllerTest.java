package unlv.erc.emergo.controller;

import android.support.test.espresso.Espresso;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
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
        onView(withText("Salvar")).perform(click());
    }

    public void testSaveSaveOption() throws UiObjectNotFoundException {
        onView(withText("Salvar")).perform(click());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testNameIsEmpty(){
        onView(withId(R.id.fullNameEditText)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButton)).perform(click());
    }
    public void testNameIsLessThanThree(){
        onView(withId(R.id.fullNameEditText)).perform(typeText("Mr"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButton)).perform(click());
    }

    public void testNameField(){
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
    }

    public void testBirthdayField() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testDateIsEmpty() {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
    }

    public void testDateIfYearIsValid(){
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1941"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
    }

    public void testIfTypeBloodLabelIsCorrect() {
        onView(withId(R.id.typeBloodTextView)).check(matches(withText("Tipo Sanguíneo")));
    }

    public void testTypeBloodField() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testIfCardiacLabelIsCorrect() {
        onView(withId(R.id.cardiacTextView)).check(matches(withText("Cardiaco")));
    }

    public void testCardiacFieldOptionYes() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }


    public void testCardiacFieldOptionNo() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testCardiacFieldOptionIDontKnow() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testIfDiabeticLabelIsCorrect() {
        onView(withId(R.id.diabeticTextView)).check(matches(withText("Diabetico")));
    }

    public void testDiabeticFieldOptionYes() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testDiabeticFieldOptionNo() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testDiabeticFieldOptionIDontKnow() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testIfHypertensionLabelIsCorrect() {
        onView(withId(R.id.hipertensionTextView)).check(matches(withText("Hipertenso")));
    }

    public void testHypertensionFieldOptionYes() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testHypertensionFieldOptionNo() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testHypertensionFieldOptionIDontKnow() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testIfSeropositiveLabelIsCorrect() {
        onView(withId(R.id.seropositiveTextView)).check(matches(withText("Soropositivo")));
    }

    public void testSeropositiveFieldOptionYes() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testSeropositiveFieldOptionNo() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testSeropositiveFieldOptionIDontKnow() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Sim")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não Sei")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testObservation() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.observationsEditText)).perform(typeText("42 = sentido da vida, o universo e tudo mais"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testUpdateUser() throws UiObjectNotFoundException {
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.observationsEditText)).perform(typeText("42 = sentido da vida, o universo e tudo mais"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withText("Alterar")).perform(click());
        onView(withId(R.id.fullNameEditText)).perform(typeText("Victor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.typeBloodSpinner)).perform(click());
        onView(withText("AB+")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.cardiacSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.diabeticSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.hipertensionSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.soropositiveSpinner)).perform(click());
        onView(withText("Não")).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.observationsEditText)).perform(typeText("42 = sentido da vida, o universo e tudo mais"));
        Espresso.closeSoftKeyboard();
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testButtonConfig(){
        onView(withId(R.id.iconMenu)).perform(click());
    }

    public void testButtonMap(){
        onView(withId(R.id.iconMap)).perform(click());
    }

    public void testGoClicked(){
        onView(withId(R.id.buttonGo)).perform(click());
    }

}
