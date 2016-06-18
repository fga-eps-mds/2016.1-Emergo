package unlv.erc.emergo.controller;


import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;
import android.support.test.espresso.Espresso;
import android.support.test.uiautomator.UiObject;

import org.junit.Before;

import dao.EmergencyContactDao;
import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MapScreenControllerTest extends ActivityInstrumentationTestCase2<MapScreenController>{
    private UiDevice device;
    private EmergencyContactDao emergencyContactDao;

    public MapScreenControllerTest() {
        super(MapScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testButtonGoOnMapScreen(){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
    }

}
