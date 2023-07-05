package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.DSL;
import br.lucasdemartha.cursoappium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {

    private DSL dsl = new DSL();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        //selecionar formulario
        dsl.clicarPorTexto("Formulário");
    }

    @After //executa depois de cada teste
    public void takeDown() {
        DriverFactory.killDriver();
    }
    
    /*@Test
    public void deveInstalarAPK() throws MalformedURLException {

        AndroidDriver<MobileElement> driver = getDriver();
        
        driver.quit();

        }*/

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException{
        
        //escrever nome
        dsl.escrever(MobileBy.AccessibilityId("nome"), "Lucas");

        //checar nome
        Assert.assertEquals("Lucas", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

    }

    @Test
    public void devePreencherCombo() throws MalformedURLException{
        
        //clicar no combo
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        //verificar a opcao selecionada
        String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        Assert.assertEquals("Nintendo Switch", text);

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException{

        //verificar status dos elementos
        //true ou false (em string)
        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

        //clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        //verificar status alterado
        Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

    }

}
