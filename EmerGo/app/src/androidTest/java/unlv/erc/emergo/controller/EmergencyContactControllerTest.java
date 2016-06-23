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

public class EmergencyContactControllerTest extends ActivityInstrumentationTestCase2<EmergencyContactController>{
    private UiDevice device;

    public EmergencyContactControllerTest() {
        super(EmergencyContactController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testSaveFirstContact(){
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
        onView(withId(R.id.saveButtonFirstContact)).check(matches(withText("Salvar")));
    }

    public void testNameFirstContactIsEmpty(){
        onView(withId(R.id.nameFirstContactEditText)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
    }
    public void testNameFirstContactIsLessThanThree(){
        onView(withId(R.id.nameFirstContactEditText)).perform(typeText("Mr"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
    }

    public void testUpdateFirstContactOption() throws UiObjectNotFoundException {
        onView(withId(R.id.nameFirstContactEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneEditText)).perform(typeText("(61)83104981"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
        onView(withId(R.id.updateButtonFirstContact)).perform(click());
        onView(withId(R.id.nameFirstContactEditText)).perform(typeText("Naiara Gatinha"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneEditText)).perform(typeText("(42)14031912"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
        onView(withId(R.id.deleteFirstContactButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testDeleteFirstContactOption() throws UiObjectNotFoundException {
        onView(withId(R.id.nameFirstContactEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneEditText)).perform(typeText("(61)83104981"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
        onView(withId(R.id.updateButtonFirstContact)).perform(click());
        onView(withId(R.id.nameFirstContactEditText)).perform(typeText("Naiara Gatinha"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneEditText)).perform(typeText("(42)14031912"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveButtonFirstContact)).perform(click());
        onView(withId(R.id.deleteFirstContactButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testSaveSecondContactOption(){
        onView(withId(R.id.saveSecondContactButton)).perform(click());
        onView(withId(R.id.saveSecondContactButton)).check(matches(withText("Salvar")));
    }

    public void testNameSecondContactIsEmpty(){
        onView(withId(R.id.nameSecondContactEditText)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveSecondContactButton)).perform(click());
    }

    public void testSaveSecondContactIsLessThanThree(){
        onView(withId(R.id.nameSecondContactEditText)).perform(typeText("Mr"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveSecondContactButton)).perform(click());
        onView(withId(R.id.saveSecondContactButton)).check(matches(withText("Salvar")));
    }

    public void testUpdateSecondContactOption() throws UiObjectNotFoundException {
        onView(withId(R.id.nameSecondContactEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneSecondContactEditText)).perform(typeText("(61)83104981"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveSecondContactButton)).perform(click());
        onView(withId(R.id.updateSecondContactButton)).perform(click());
        onView(withId(R.id.nameSecondContactEditText)).perform(typeText("Naiara Gatinha"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneSecondContactEditText)).perform(typeText("(42)14031912"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveSecondContactButton)).perform(click());
        onView(withId(R.id.deleteSecondContactButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testDeleteSecondContactOption() throws UiObjectNotFoundException {
        onView(withId(R.id.nameSecondContactEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneSecondContactEditText)).perform(typeText("(61)83104981"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveSecondContactButton)).perform(click());
        onView(withId(R.id.updateSecondContactButton)).perform(click());
        onView(withId(R.id.nameSecondContactEditText)).perform(typeText("Naiara Gatinha"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneSecondContactEditText)).perform(typeText("(42)14031912"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveSecondContactButton)).perform(click());
        onView(withId(R.id.deleteSecondContactButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testSaveThirdContactOption(){
        onView(withId(R.id.saveThirdContactButton)).perform(click());
        onView(withId(R.id.saveThirdContactButton)).check(matches(withText("Salvar")));
    }

    public void testNameThirdContactIsEmpty(){
        onView(withId(R.id.nameThirdContactEditText)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveThirdContactButton)).perform(click());
    }

    public void testSaveThirdContactIsLessThanThree(){
        onView(withId(R.id.nameThirdContactEditText)).perform(typeText("Mr"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveThirdContactButton)).perform(click());
        onView(withId(R.id.saveThirdContactButton)).check(matches(withText("Salvar")));
    }

    public void testUpdateThirdContactOption() throws UiObjectNotFoundException {
        onView(withId(R.id.nameThirdContactEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneThirdContactEditText)).perform(typeText("(61)83104981"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveThirdContactButton)).perform(click());
        onView(withId(R.id.updateThirdContactButton)).perform(click());
        onView(withId(R.id.nameThirdContactEditText)).perform(typeText("Naiara Gatinha"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneThirdContactEditText)).perform(typeText("(42)14031912"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveThirdContactButton)).perform(click());
        onView(withId(R.id.deleteThirdContactButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testDeleteThirdContactOption() throws UiObjectNotFoundException {
        onView(withId(R.id.nameThirdContactEditText)).perform(typeText("MrVictor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneThirdContactEditText)).perform(typeText("(61)83104981"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveThirdContactButton)).perform(click());
        onView(withId(R.id.updateThirdContactButton)).perform(click());
        onView(withId(R.id.nameThirdContactEditText)).perform(typeText("Naiara Gatinha"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.phoneThirdContactEditText)).perform(typeText("(42)14031912"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveThirdContactButton)).perform(click());
        onView(withId(R.id.deleteThirdContactButton)).perform(click());
        UiObject button = device.findObject(new UiSelector().text("Sim"));
        button.click();
    }

    public void testButtonConfig(){
        onView(withId(R.id.iconMenu)).perform(click());
    }


    public void testButtonMap(){
        onView(withId(R.id.iconMap)).perform(click());
    }
}
