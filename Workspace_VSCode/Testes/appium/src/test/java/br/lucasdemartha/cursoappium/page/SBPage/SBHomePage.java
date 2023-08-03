package br.lucasdemartha.cursoappium.page.SBPage;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;

public class SBHomePage extends BasePage{

    public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
    
}
