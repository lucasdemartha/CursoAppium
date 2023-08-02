package br.lucasdemartha.cursoappium.page;

import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.lucasdemartha.cursoappium.core.BasePage;

public class MenuPage extends BasePage {


    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlerta(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }

    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarCliques(){
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe(){
        clicarPorTexto("Swipe");
    }

    public void clicarSwipeList(){
        //scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando");
        scrollDown();

         //acessar menu

        clicarPorTexto("Swipe List");
    }

    public void acessarDragNDrop(){
        //scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando");
        scrollDown();

         //acessar menu

        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarSBNativo(){
        clicarPorTexto("SeuBarriga Nativo");
    }

    

}
