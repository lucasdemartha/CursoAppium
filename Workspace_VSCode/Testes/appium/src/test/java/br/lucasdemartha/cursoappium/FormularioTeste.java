package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.FormularioPage;
import br.lucasdemartha.cursoappium.page.MenuPage;

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

}
