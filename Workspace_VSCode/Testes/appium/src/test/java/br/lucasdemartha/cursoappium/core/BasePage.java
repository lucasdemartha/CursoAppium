package br.lucasdemartha.cursoappium.core;

import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.openqa.selenium.By;

public class BasePage {

    public void escrever(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto){
        return getDriver().findElements(By.xpath("//*[@text='"+texto+"']"))
            .size() > 0;
    }

}
