package unlv.erc.emergo.helper;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import helper.Services;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

/**
 * Created by AndreBedran on 6/21/16.
 */
public class ServicesUnitTest extends ActivityInstrumentationTestCase2<Services>{


    private UiDevice device;

    public ServicesUnitTest(Class<Services> activityClass) {
        super(activityClass);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }
}
