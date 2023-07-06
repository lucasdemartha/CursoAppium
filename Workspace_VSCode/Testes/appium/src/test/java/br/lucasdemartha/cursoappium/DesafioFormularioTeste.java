package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
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

}
