package unlv.erc.emergo.controller;

import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import dao.DataAccessObject;
import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class InformationUsScreenControllerInterfaceTest extends ActivityInstrumentationTestCase2<InformationUsScreenController> {

    private UiDevice device;

    public InformationUsScreenControllerInterfaceTest() {
        super(InformationUsScreenController.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testIfButtonGoWorks(){
        onView(withId(R.id.buttonOkay)).perform(click());
        onView(withId(R.id.iconList)).perform(click());
        onView(withId(R.id.list_of_hospitalUnit)).perform(click());
        onView(withId(R.id.buttonGo)).perform(click());
    }

}
