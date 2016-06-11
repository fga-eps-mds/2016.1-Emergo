package unlv.erc.emergo;

import android.content.Intent;
import android.net.Uri;

import junit.framework.TestCase;

import unlv.erc.emergo.controller.MapScreenController;

public class MapScreenControllerUnitTest extends TestCase {


    MapScreenController mapScreenController = new MapScreenController();

    public void testCallTheRigthNumber(){

        assertTrue("tel:33713601".equals(mapScreenController.SAMUNumber));

    }
}
