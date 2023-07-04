package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

    public AndroidDriver<MobileElement> driver;

    @Before
    public void inicializarAppium() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "E:\\CursoAppium\\CursoAppium\\Workspace_VSCode\\Testes\\appium\\src\\resources\\CTAppium_2_0.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //selecionar formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();
    }

    @After //executa depois de cada teste
    public void takeDown() {
        driver.quit();
    }
    
    /*@Test
    public void deveInstalarAPK() throws MalformedURLException {

        AndroidDriver<MobileElement> driver = getDriver();
        
        driver.quit();

        }*/

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException{
        
        //escrever nome
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Lucas");

        //checar nome

        String text = campoNome.getText();
        Assert.assertEquals("Lucas", text);

    }

    @Test
    public void devePreencherCombo() throws MalformedURLException{
        
        //clicar no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();
        
        //selecionar a opcao desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //verificar a opcao selecionada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException{

        //verificar status dos elementos
        MobileElement check = driver.findElement(By.className("android.widget.CheckBox")); //fazendo por class
        MobileElement switchElement = driver.findElement(MobileBy.AccessibilityId("switch")); //fazendo por contest-desc

        //true ou false (em string)
        Assert.assertTrue(check.getAttribute("checked").equals("false"));
        Assert.assertTrue(switchElement.getAttribute("checked").equals("true"));

        //clicar nos elementos
        check.click();
        switchElement.click();

        //verificar status alterado
        Assert.assertFalse(check.getAttribute("checked").equals("false"));
        Assert.assertFalse(switchElement.getAttribute("checked").equals("true"));

    }

}
