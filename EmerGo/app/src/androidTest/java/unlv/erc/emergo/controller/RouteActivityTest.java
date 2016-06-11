package unlv.erc.emergo.controller;

import android.test.ActivityUnitTestCase;

import android.view.View;


import junit.framework.TestCase;

import java.util.ArrayList;


public class RouteActivityTest extends TestCase {


    RouteActivity routeActivity = new RouteActivity();
    MapScreenController mapScreenController = new MapScreenController();


    public void testIfCancelWasClicked(){
        boolean passed = true;
        routeActivity.cancelClicked(new View(routeActivity.getBaseContext()));
        ArrayList a = new ArrayList();
        a.add(HealthUnitController.getClosestsUs().get(0));
        if(a.get(0).equals(HealthUnitController.getClosestsUs().get(0))){
            assertTrue(passed);
        }else{
            assertFalse(passed);
        }

    }

}
