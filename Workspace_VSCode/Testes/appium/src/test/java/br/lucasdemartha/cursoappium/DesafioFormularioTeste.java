package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.DSL;
import br.lucasdemartha.cursoappium.core.DriverFactory;

public class DesafioFormularioTeste {

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
    @Test
    public void deveRealizarCadastro() throws MalformedURLException{

        //preencher campos
        dsl.escrever(By.className("android.widget.EditText"), "Lucas");

        //clicar no combo
        dsl.selecionarCombo(By.className("android.widget.Spinner"), "PS4");

        //selecionar checkbox
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(By.className("android.widget.Switch"));

        //selecionar salvar
        dsl.clicarPorTexto("SALVAR");

        //validar os campos
        Assert.assertEquals("Nome: Lucas", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")));

        Assert.assertEquals("Console: ps4", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));

        Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));

        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.Switch")));

    }

}
