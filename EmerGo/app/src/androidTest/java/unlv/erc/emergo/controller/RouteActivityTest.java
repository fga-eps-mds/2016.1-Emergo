package unlv.erc.emergo.controller;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;

import android.view.View;
import android.widget.Button;


import junit.framework.TestCase;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


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

    public void testSetUserLocationButton(){
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
    }















}
