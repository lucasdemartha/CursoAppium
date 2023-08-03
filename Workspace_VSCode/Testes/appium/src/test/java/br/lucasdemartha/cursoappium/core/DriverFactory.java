package br.lucasdemartha.cursoappium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
    
    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver(){
        if(driver == null){
            createDriver();
        }
        return driver;
    }

    private static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "E:\\CursoAppium\\CursoAppium\\Workspace_VSCode\\Testes\\appium\\src\\resources\\CTAppium_2_0.apk");

        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void createTestObjectDriver() {
        MutableCapabilities caps = new MutableCapabilities();
        // caps.setCapability("deviceName","Samsung Galaxy S9 Plus FHD GoogleAPI
        // Emulator");
        // caps.setCapability("platformVersion","8.1");
        // caps.setCapability("appiumVersion", "1.9.1");

        caps.setCapability("automationName", "UiAutomator2");

        caps.setCapability("browserName", "");
        caps.setCapability("platformName", "Android");
        // caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "Samsung_Galaxy_S9_free");
        caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "lucasdemartha");
        sauceOptions.setCapability("accessKey", "86533244-99dc-408d-9750-59621ac0c58c");
        caps.setCapability("sauce:options", sauceOptions);

        try {
            driver = new AndroidDriver<MobileElement>(new URL(
                    "https://oauth-oldbutpuregold7-65c3b:06edba44-07e4-4389-aec3-ac6aed87148e@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                    caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
