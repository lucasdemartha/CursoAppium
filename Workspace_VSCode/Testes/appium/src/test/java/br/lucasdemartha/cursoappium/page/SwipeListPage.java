package br.lucasdemartha.cursoappium.page;

import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;
import br.lucasdemartha.cursoappium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeListPage extends BasePage{

    public void swipeElementRight(String opcao){
        swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
    }

    public void swipeElementLeft(String opcao){
        swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
    }

    public void clicarBotaoMais(){
		MobileElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
		new TouchAction<>(getDriver())
			.tap(TapOptions.tapOptions().withElement(ElementOption.element(botao, 50, 0)))
			.perform();
    }
    
}
