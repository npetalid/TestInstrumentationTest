package gr.petalidis.testinstrumentationtest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)

public class ExampleUITest {

        private static final String BASIC_SAMPLE_PACKAGE
                = "gr.petalidis.testinstrumentationtest";
        private static final int LAUNCH_TIMEOUT = 5000;
        private UiDevice mDevice;

        @Before
        public void startMainActivityFromHomeScreen() {
            // Initialize UiDevice instance
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

            // Start from the home screen
            mDevice.pressHome();

            // Wait for launcher
            final String launcherPackage = mDevice.getLauncherPackageName();
            assertThat(launcherPackage, notNullValue());
            mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                    LAUNCH_TIMEOUT);

            // Launch the app
            Context context = InstrumentationRegistry.getContext();
            final Intent intent = context.getPackageManager()
                    .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
            // Clear out any previous instances
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);

            // Wait for the app to appear
            mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                    LAUNCH_TIMEOUT);
        }


        @Test
    public void testQuote() throws Exception {
        mDevice.findObject(new UiSelector()
                .packageName(BASIC_SAMPLE_PACKAGE).resourceId(BASIC_SAMPLE_PACKAGE+":id/getButton")).click();

        //    UiObject2 result = mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, ":id/outputTextView"));
            UiObject result = mDevice.findObject(new UiSelector()
                    .packageName(BASIC_SAMPLE_PACKAGE).resourceId("gr.petalidis.testinstrumentationtest:id/outputTextView"));
        assertEquals("This is news to me!", result.getText());
    }
    }

