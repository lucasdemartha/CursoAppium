package br.lucasdemartha.cursoappium.page;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome){
        //escrever nome
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome(){
        //checar nome
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
        //clicar no combo
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo(){
        //verificar valor do combo
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck(){
        //clicar no check
        clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch(){
        //clicar no switch
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado(){
        //verificar se o check esta marcado
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado(){
        //verificar se o switch esta marcado
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvar(){
        //clicar em salvar
        clicarPorTexto("SALVAR");
    }

    public String obterNomeCadastrado(){
        //verificar nome cadastrado
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String obterConsoleCadastrado(){
        //verificar console cadastrado
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String obterSwitchCadastrado(){
        //verificar switch cadastrado
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String obterCheckCadastrado(){
        //verificar check cadastrado
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

}
