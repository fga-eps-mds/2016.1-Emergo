package unlv.erc.emergo.controller;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.runner.RunWith;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class RegisterUserControllerTest extends ActivityInstrumentationTestCase2<RegisterUserController>{

    public RegisterUserControllerTest() {
        super(RegisterUserController.class);
    }

    public void testSaveOption(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
        onView(withId(R.id.saveButton)).check(matches(withText("Salvar")));
    }

    public void testIfNameLabelIsCorrect(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameTextView)).check(matches(withText("Nome")));
    }

    public void testNameField(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.fullNameTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.fullNameEditText)).perform(typeText("MrVictor"));
        onView(withId(R.id.fullNameEditText)).perform(click());
        onView(withId(R.id.fullNameEditText)).check(matches(withText("MrVictor")));
    }

    public void testIfDateLabelIsCorrect() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayTextView)).check(matches(withText("Data de Nascimento")));
    }

    public void testDateField(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.birthdayEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("09/07/1995"));
        onView(withId(R.id.birthdayEditText)).perform(click());
        onView(withId(R.id.birthdayEditText)).check(matches(withText("09/07/1995")));
    }


    public void testUpdateOption(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Alterar")).perform(click());
        onView(withId(R.id.updateButton)).check(matches(isDisplayed()));
        onView(withId(R.id.updateButton)).check(matches(withText("Alterar")));
    }

    public void testDeleteOption(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Excluir")).perform(click());
        onView(withId(R.id.deleteButton)).check(matches(isDisplayed()));
        onView(withId(R.id.deleteButton)).check(matches(withText("Excluir")));
    }

    public void testBirthday(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.birthdayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayEditText)).perform(typeText("14/03/1912"));
        onView(withId(R.id.birthdayEditText)).perform(click());
        onView(withId(R.id.birthdayEditText)).check(matches(withText("14/03/1912")));
    }

}
