package unlv.erc.emergo;

import android.content.Context;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import unlv.erc.emergo.controller.HealthUnitController;
import unlv.erc.emergo.controller.SearchUsController;
import unlv.erc.emergo.model.HealthUnit;

/**
 * Created by AndreBedran on 6/9/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class SearchUsControllerTest extends TestCase{

    @Mock
    Context aContext;

    @Test
    public void testGetSearchUsList() {

        boolean hasPassed = false;
        HealthUnitController healthUnitController = new HealthUnitController(aContext);
        ArrayList<HealthUnit> array = healthUnitController.getSearchsUs();
        SearchUsController searchUsController = new SearchUsController();

        ArrayList<String> testArray = searchUsController.getSearchsUs(array);

        if (testArray.size() > 0){
            hasPassed = true;
        } else {
            //Nothing to do
        }

        assertTrue(hasPassed);

    }

}
