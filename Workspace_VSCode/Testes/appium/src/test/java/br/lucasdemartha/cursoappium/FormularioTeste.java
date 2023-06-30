package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {
    @Test
    public void deveInstalarAPK() throws MalformedURLException {

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

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        //desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        //desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "E:\\CursoAppium\\CursoAppium\\Workspace_VSCode\\Testes\\appium\\src\\resources\\CTAppium_2_0.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //selecionar formulario
        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

        /*for(MobileElement elemento: elementosEncontrados){
            System.out.println(elemento.getText());
        }*/

        elementosEncontrados.get(1).click();

        //escrever nome
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Lucas");

        //checar nome

        String text = campoNome.getText();
        Assert.assertEquals("Lucas", text);

        driver.quit();
    }
}
