package unlv.erc.emergo.controller;

import android.support.test.espresso.Espresso.*;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;


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

    public void testIfSearchMenuIsClickable() {
        onView(withId(R.id.search))
                .perform(click());
    }

    public void testIfFieldReceivesText() {

        onView(withId(R.id.search))
                .perform(click());

        View aView = getActivity().getCurrentFocus();

        onView(withId(aView.getId()))
                .perform(typeText("Hos"));


    }

    public void testIfResultsAreShown() {

        onView(withId(R.id.search))
                .perform(click());

        View aView = getActivity().getCurrentFocus();

        onView(withId(aView.getId()))
                .perform(typeText("Hos"));

        onView(withId(R.id.list_of_search_us))
                .check(matches(isDisplayed()));


    }
}
