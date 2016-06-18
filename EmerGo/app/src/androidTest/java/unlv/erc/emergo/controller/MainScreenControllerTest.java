package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.Before;

import dao.EmergencyContactDao;
import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;


public class MainScreenControllerTest extends ActivityInstrumentationTestCase2<MainScreenController> {
    private UiDevice device;
    private EmergencyContactDao emergencyContactDao;

    public MainScreenControllerTest() {
        super(MainScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testButtonGo(){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("GO!")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
    }

    public void testButtonOkay(){
        onView(withId(R.id.buttonOkay)).check(matches(isDisplayed()));
        onView(withText("Estou Bem")).perform(click());
        onView(withId(R.id.buttonOkay));
    }


}