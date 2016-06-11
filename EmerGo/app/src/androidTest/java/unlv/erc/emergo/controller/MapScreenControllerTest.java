package unlv.erc.emergo.controller;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MapScreenControllerTest extends ActivityInstrumentationTestCase2<MapScreenController> {

    public MapScreenControllerTest(){
        super(MapScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity().getCallingActivity();
    }

    public void testButtonGoClick(){

        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("GO!")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
    }
}
