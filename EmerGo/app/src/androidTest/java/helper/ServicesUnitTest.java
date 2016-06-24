package helper;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

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
