package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MapScreenControllerTest extends ActivityInstrumentationTestCase2<MapScreenController> {
    private UiDevice device;

    public MapScreenControllerTest(){
        super(MapScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testSearchClick(){
        onView(withId(R.id.iconSearch)).perform(click());
    }

    public void testMapClick(){
        onView(withId(R.id.iconMap)).perform(click());
    }

    public void testConfigClick(){
        onView(withId(R.id.iconMenu)).perform(click());
    }
}
