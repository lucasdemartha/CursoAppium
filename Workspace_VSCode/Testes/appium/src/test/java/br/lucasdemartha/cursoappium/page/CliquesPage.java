package br.lucasdemartha.cursoappium.page;

import static br.lucasdemartha.cursoappium.core.DriverFactory.*;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage extends BasePage{

    public void cliqueLongo() {
        new AndroidTouchAction(getDriver())
        .longPress(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))))
        .perform();
}

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
    
}
