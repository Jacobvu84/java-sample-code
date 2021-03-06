import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FrenzyAppAndroidParallelTest1 extends FrenzyAppBaseTest {

    public void launchFrenzy(Integer port) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shopify.frenzy.app");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.shopify.frenzy.feed.ui.FeedActivity");
            capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
            capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
            driver = new AndroidDriver<>(new URL(HUB_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFrenzyParallel() {
        launchFrenzy(8200);
        performTest(driver);
    }
}
