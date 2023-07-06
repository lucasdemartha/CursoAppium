package br.lucasdemartha.cursoappium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTeste {

    @Rule
	public TestName testName = new TestName();

    @AfterClass
    public static void finalizarClasse() {
        DriverFactory.killDriver();
    }
    
    @After //executa depois de cada teste
    public void takeDown() {
        gerarScreenShot();
        DriverFactory.getDriver().resetApp();
    }

    public void gerarScreenShot() {
    	try {
    		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
