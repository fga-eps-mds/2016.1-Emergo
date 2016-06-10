package unlv.erc.emergo.controller;


import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class EmergencyContactControllerTest extends ActivityInstrumentationTestCase2<EmergencyContactController>{
    private UiDevice device;
    private MedicalRecordsController register;

    public EmergencyContactControllerTest() {
        super(EmergencyContactController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testSaveOption(){
        onView(withId(R.id.saveButtonFirstContact)).check(matches(isDisplayed()));
        onView(withText("Salvar")).perform(click());
        onView(withId(R.id.saveButtonFirstContact)).check(matches(withText("Salvar")));
    }

}
