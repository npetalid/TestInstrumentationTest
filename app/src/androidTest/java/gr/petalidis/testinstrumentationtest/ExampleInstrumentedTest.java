package gr.petalidis.testinstrumentationtest;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import gr.petalidis.testinstrumentationtest.activity.MainActivity;
import gr.petalidis.testinstrumentationtest.controller.QuoteOfTheDayController;
import gr.petalidis.testinstrumentationtest.stubs.QuoteOfTheDayClientStub;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.mockito.Mockito.mock;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule = new
            ActivityTestRule<MainActivity>(MainActivity.class,false,false);

    Intent intent;
    @Before
    public void setUp()
    {
        intent = new Intent();
    }
    @Test
    public void testMainScreen() throws Exception {
        mMainActivityTestRule.launchActivity(new Intent());

        onView(withId(R.id.helloWorldLabel)).check(matches(allOf(withText("HelloWorld"), isDisplayed())));
    }

    @Test
    public void testGetQuote() throws Exception {

        final String expectedAnswer = "What's up doc?";


        intent.putExtra("quoteOfTheDay", new QuoteOfTheDayController(new QuoteOfTheDayClientStub()));
        mMainActivityTestRule.launchActivity(intent);


        onView(withId(R.id.getButton)).perform(click());

        onView(withId(R.id.outputTextView)).check(matches(allOf(withText(expectedAnswer), isDisplayed())));

    }

}
