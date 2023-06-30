package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Formulario {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        //desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        //desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "E:\\CursoAppium\\CursoAppium\\Workspace_VSCode\\Testes\\appium\\src\\resources\\CTAppium_2_0.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.quit();

        }
}
