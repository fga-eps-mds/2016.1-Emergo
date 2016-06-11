package unlv.erc.emergo.controller;

import android.support.test.espresso.Espresso.*;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by AndreBedran on 6/10/16.
 */
@RunWith(AndroidJUnit4.class)
public class SearchUsControllerUITest {

    @Rule
    public ActivityTestRule

    @Test
    public void testSearchTypeField() {

        String stringToType = "Espresso";

        onView(withId(R.menu.menu_search))
                .perform(typeText(stringToType))
                .perform(closeSoftKeyboard())
                .check(matches(withText(stringToType)));

    }
}
