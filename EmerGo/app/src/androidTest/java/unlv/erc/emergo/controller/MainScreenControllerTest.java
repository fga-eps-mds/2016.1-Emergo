package unlv.erc.emergo.controller;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;

import unlv.erc.emergo.R;

public class MainScreenControllerTest extends ActivityInstrumentationTestCase2<MainScreenController> {

    public MainScreenControllerTest(){
        super(MainScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity().getCallingActivity();
    }

    public void testButtonGoClick(){

        onView(ViewMatchers.withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("GO!")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
    }


    public void testButtonOkayClick(){

        onView(withId(R.id.buttonOkay)).check(matches(isDisplayed()));
        onView(withText("Estou Bem")).perform(click());
        onView(withId(R.id.buttonOkay)).check(matches(withText("Estou Bem")));
    }

    public void testLogoEmerGoView(){

        onView(withId(R.id.logoEmerGo)).check(matches(isDisplayed()));
    }
}
