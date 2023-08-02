package br.lucasdemartha.cursoappium.page;

import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;

public class CliquesPage extends BasePage{

    public void cliqueLongo(){
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
    
}
