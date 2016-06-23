package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainScreenControllerTest extends ActivityInstrumentationTestCase2<MainScreenController> {
    private UiDevice device;
    public MainScreenControllerTest(){
        super(MainScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity().getCallingActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testButtonGoClick(){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonGo)).perform(click());
    }

    public void testButtonOkayClick(){
        onView(withId(R.id.buttonOkay)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonOkay)).perform(click());
    }

    public void testImageVisible(){
        onView(withId(R.id.logoEmerGo)).check(matches(isDisplayed()));
    }
}
