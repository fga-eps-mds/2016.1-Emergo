package unlv.erc.emergo.controller;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import unlv.erc.emergo.R;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainScreenControllerTest extends ActivityInstrumentationTestCase2<MainScreenController>{

    MainScreenController tela = new MainScreenController();

    public MainScreenControllerTest(){
        super(MainScreenController.class);
    }

    public void testGoButtonClickability(){
        onView(withId(tela.goButton.getId())).perform(click());
    }


    public void testOkButtonClickability(){
        onView(withId(tela.fineButton.getId())).perform(click());
    }

    public void testGoButtonVisibility(){

        MainScreenController tela = new MainScreenController();

        assertTrue(tela.goButton.isEnabled());

    }


    public void testOkButtonVisibility(){

        MainScreenController tela = new MainScreenController();

        assertTrue(tela.fineButton.isEnabled());

    }


}