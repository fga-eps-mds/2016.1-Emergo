package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class RouteActivityTest extends ActivityInstrumentationTestCase2<RouteActivity> {
    private UiDevice device;

    public RouteActivityTest() {
        super(RouteActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testIfButtonCancelCallIsWorking() {
        onView(withId(R.id.buttonGo)).perform(click());
    }

    public void testIfButtonSelfLocationIsWorking() {
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.cancelarLigacao)).perform(click());
        onView(withId(R.id.selfLocation)).perform(click());
    }

    public void testListsUs(){
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.cancelarLigacao)).perform(click());
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.iconList)).perform(click());
        onView(withId(R.id.buttonGo)).perform(click());
        onView(withId(R.id.cancelarLigacao)).perform(click());
    }
}
