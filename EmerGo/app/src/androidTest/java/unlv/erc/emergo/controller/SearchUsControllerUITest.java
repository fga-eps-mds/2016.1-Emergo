package unlv.erc.emergo.controller;

import android.support.test.espresso.Espresso.*;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by AndreBedran on 6/10/16.
 */

public class SearchUsControllerUITest extends ActivityInstrumentationTestCase2<SearchUsController>{

    public SearchUsControllerUITest() { super(SearchUsController.class); }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }



    public void testSearchMenuAvailability() {
        onView(withId(R.id.search))
                .check(matches(isDisplayed()));
    }

    public void testIfSearchFieldIsEnabled() {

        onView(withId(R.id.search))
                .check(matches(isEnabled()));
    }

    public void testSearchFieldReceivesTypeSet() {

        String type = "Espresso";

        onView(withId(R.id.search))
                .perform(typeText(type))
                .perform(closeSoftKeyboard());

        //TODO see why doesnt work.

        onView(withId(R.id.search))
                .check(matches(withText(type)));

    }
}
