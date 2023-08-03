package br.lucasdemartha.cursoappium.page.SBPage;
import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage{

    public void excluirMovimentacao(String desc) {
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
    
}
