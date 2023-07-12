package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.core.DriverFactory;
import br.lucasdemartha.cursoappium.page.FormularioPage;
import br.lucasdemartha.cursoappium.page.MenuPage;
public class DesafioFormularioTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        //selecionar formulario
        menu.acessarFormulario();
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException{

        //preencher campos
        page.escreverNome("Lucas");

        //clicar no combo
        page.selecionarCombo("PS4");

        //selecionar checkbox
        page.clicarCheck();
        page.clicarSwitch();

        //selecionar salvar
        page.salvar();

        //validar os campos
        Assert.assertEquals("Nome: Lucas", page.obterNomeCadastrado());

        Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());

        Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));

        Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));

    }

        @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException{

        //preencher campos
        page.escreverNome("Lucas");

        //clicar no combo
        page.selecionarCombo("PS4");

        //selecionar checkbox
        page.clicarCheck();
        page.clicarSwitch();

        //selecionar salvar
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        page.salvarDemorado();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Lucas']")));
        //esperar(5000);

        //validar os campos
        Assert.assertEquals("Nome: Lucas", page.obterNomeCadastrado());

        Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());

        Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));

        Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));

    }


}
