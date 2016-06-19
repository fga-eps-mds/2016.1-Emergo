package unlv.erc.emergo.controller;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

public class MapScreenControllerTest extends ActivityInstrumentationTestCase2<MapScreenController> {

    public MapScreenControllerTest(){
        super(MapScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
    }

    /*public void testButtonGoClick(){

        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("GO!")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
    }*/
/*
    public void testButtonListUsClick(){

        onView(withId(R.id.iconList)).check(matches(isDisplayed()));
        onView(withId(R.id.iconList)).perform(click());
    }

    public void testButtonMapClick(){

        onView(withId(R.id.iconMap)).check(matches(isDisplayed()));
        onView(withId(R.id.iconMap)).perform(click());
    }
*/
}
