package unlv.erc.emergo;

import android.content.Context;
import android.support.v7.widget.SearchView;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import unlv.erc.emergo.controller.HealthUnitController;
import unlv.erc.emergo.controller.SearchUsController;


/**
 * Created by AndreBedran on 6/9/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchUsControllerTest extends TestCase{


    @Mock
    Context aContext;
    SearchUsController searchUsController;
    HealthUnitController healthUnitController;

    @Test
    public void testIfInstanceIsNotNull() {

        searchUsController = new SearchUsController();

        assertNotNull(searchUsController);

    }

}
