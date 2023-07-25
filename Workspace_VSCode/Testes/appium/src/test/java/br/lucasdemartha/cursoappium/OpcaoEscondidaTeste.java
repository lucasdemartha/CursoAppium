package br.lucasdemartha.cursoappium;

import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class OpcaoEscondidaTeste extends BaseTeste{

    private MenuPage menu = new MenuPage();
    
    @Test
    public void deveEncontrarOpcaoEscondida(){
        //scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando");
        menu.scrollDown();

        //acessar menu

        menu.clicarPorTexto("Opção bem escondida");

        //verificar opcao
        Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());

        //sair
        menu.clicarPorTexto("OK");
    }

}
