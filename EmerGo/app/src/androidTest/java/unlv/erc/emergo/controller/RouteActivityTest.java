package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import java.util.ArrayList;

import dao.DataAccessObject;
import helper.Services;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class RouteActivityTest extends ActivityInstrumentationTestCase2<RouteActivity> {

    private UiDevice device;
    public RouteActivityTest(){
        super(RouteActivity.class);
    }

    @Before
    public void setUp() throws  Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }



    public void testIfCatchException(){
        boolean passed = false;
        try{
            onView(withId(R.id.selfLocation)).perform(click());
            assertTrue(passed);
        }catch (RuntimeException ex){
            assertFalse(passed);
        }

    }

    public void testButtonMedical(){
        onView(withId(R.id.buttonGo)).perform(click());
    }




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
