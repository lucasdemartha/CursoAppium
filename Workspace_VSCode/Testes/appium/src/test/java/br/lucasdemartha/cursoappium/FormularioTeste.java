package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.FormularioPage;
import br.lucasdemartha.cursoappium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        //selecionar formulario
        menu.acessarFormulario();
    }

    /*@Test
    public void deveInstalarAPK() throws MalformedURLException {

        AndroidDriver<MobileElement> driver = getDriver();
        
        driver.quit();

        }*/

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException{
        
        //escrever nome
        page.escreverNome("Lucas");

        //checar nome
        Assert.assertEquals("Lucas", page.obterNome());

    }

    @Test
    public void devePreencherCombo() throws MalformedURLException{
        
        //clicar no combo
        page.selecionarCombo("Nintendo Switch");

        //verificar a opcao selecionada
        Assert.assertEquals("Nintendo Switch", page.obterValorCombo());

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException{

        //verificar status dos elementos
        //true ou false (em string)
        Assert.assertFalse(page.isCheckMarcado());
        Assert.assertTrue(page.isSwitchMarcado());

        //clicar nos elementos
        page.clicarCheck();
        page.clicarSwitch();

        //verificar status alterado
        Assert.assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwitchMarcado());
    }

    @Test
    public void deveAlterarData(){
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("20/01/2000"));
    }

    @Test
    public void deveAlterarHora(){
        page.clicarPorTexto("12:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("10:40"));
    }

    @Test
    public void deveInteragirComSeekBar(){
        //clicar no seekbar
        page.clicarSeekBar(0.67);

        //salvar
        page.salvar();
    }

}
