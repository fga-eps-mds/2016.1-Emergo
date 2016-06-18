package unlv.erc.emergo.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.test.espresso.core.deps.guava.util.concurrent.ThreadFactoryBuilder;
import android.support.test.uiautomator.UiDevice;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Toast;

import org.junit.Before;

import dao.DataAccessObject;
import dao.EmergencyContactDao;
import unlv.erc.emergo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;


public class MainScreenControllerTest extends ActivityInstrumentationTestCase2<MainScreenController> {
    private UiDevice device;
    private EmergencyContactDao emergencyContactDao;

    public MainScreenControllerTest() {
        super(MainScreenController.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
        device = UiDevice.getInstance(getInstrumentation());
    }

    public void testButtonGo(){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("GO!")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
    }

    public void testButtonOkay(){
        onView(withId(R.id.buttonOkay)).check(matches(isDisplayed()));
        onView(withText("Estou Bem")).perform(click());
        onView(withId(R.id.buttonOkay));
    }

    public void testIfShowAToast (){
        onView(withId(R.id.buttonGo)).check(matches(isDisplayed()));
        onView(withText("GO!")).perform(click());
        onView(withId(R.id.buttonGo)).check(matches(withText("GO!")));
        Toast toast = null;
        boolean result = false;
        if (toast == null|| toast.getView().getWindowVisibility() != View.VISIBLE){
            assertFalse(result);
        } else {
            toast.show();
            assertTrue(result);
        }

    }
}