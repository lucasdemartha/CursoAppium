package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesafioFormularioTeste {
    private AndroidDriver<MobileElement> inicializarAppium() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "E:\\CursoAppium\\CursoAppium\\Workspace_VSCode\\Testes\\appium\\src\\resources\\CTAppium_2_0.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void devePreencherCamposDesafio() throws MalformedURLException{
        AndroidDriver<MobileElement> driver = inicializarAppium();
        
        //selecionar o formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click(); // * = qualquer elemento

        //preencher o formulario
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Lucas");

        //clicar no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //selecionar o valor
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

        //selecionar checkbox
        MobileElement check = driver.findElement(By.className("android.widget.CheckBox")); //fazendo por class
        MobileElement switchElement = driver.findElement(By.className("android.widget.Switch")); //fazendo por class
        check.click();
        switchElement.click();

        //selecionar salvar
        driver.findElement(By.className("android.widget.Button")).click();

        //validar os campos
        MobileElement text = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Lucas']"));
        Assert.assertEquals("Nome: Lucas", text.getText());

        MobileElement text2 = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        Assert.assertEquals("Console: ps4", text2.getText());

        MobileElement text3 = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
        Assert.assertTrue(text3.getText().endsWith("Marcado"));

        MobileElement text4 = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
        Assert.assertTrue(text4.getText().endsWith("Off"));

        driver.quit();
    }

}
