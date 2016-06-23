package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ConfigControllerTest extends ActivityInstrumentationTestCase2<ConfigController> {
    private UiDevice device;
    private ConfigController config;

    public ConfigControllerTest() {
        super(ConfigController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testButtonMedical(){
        onView(withId(R.id.emergencyContact)).perform(click());
    }

    public void testButtonContact(){
        onView(withId(R.id.medicalRecords)).perform(click());
    }

    public void testButtonConfig(){
        onView(withId(R.id.iconMenu)).perform(click());
    }

    public void testButtonMap(){
        onView(withId(R.id.iconMap)).perform(click());
    }

    public void testButtonAboutApp(){
        onView(withId(R.id.app)).perform(click());
    }
}
