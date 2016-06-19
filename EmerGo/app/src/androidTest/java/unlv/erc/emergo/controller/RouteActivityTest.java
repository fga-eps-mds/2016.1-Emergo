package unlv.erc.emergo.controller;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;


public class RouteActivityTest extends ActivityInstrumentationTestCase2<RouteActivity> {

    public RouteActivityTest(){
        super(RouteActivity.class);
    }

    @Before
    public void setUp() throws  Exception{
        super.setUp();
        getActivity();
    }

    private RouteActivity routeActivity = new RouteActivity();

    /*public void testSetUserLocationButton(){
        onView(withId(R.id.button)).check(matches(isDisplayed()));
        onView(withText("YOU")).perform(click());
        onView(withId(R.id.button)).check(matches(withText("YOU")));
    }

    public void testIdUserLocationButtonIsClickable(){
        Button buttonUserLocation = (Button) routeActivity.findViewById(R.id.button);
        boolean valido = true;
        if(buttonUserLocation.isClickable()){
            assertTrue(valido);
        }else{
            assertFalse(valido);
        }
    }

    public void testIfLabelUserLocationIsCorret(){
        onView(withId(R.id.button)).check(matches(isDisplayed()));
        onView(withText("YOU")).perform(click());
    }

    public void testButtonCancel(){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("CANCELAR")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("CANCELAR")));
    }

    public void testIfButtonCancelIsClickable(){
        Button buttonUserLocation = (Button) routeActivity.findViewById(R.id.buttonGo);
        boolean valido = true;
        if(buttonUserLocation.isClickable()){
            assertTrue(valido);
        }else{
            assertFalse(valido);
        }
    }

    public void testIfLabelCancelIsCorret(){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("CANCELAR")).perform(click());
    }*/















}
