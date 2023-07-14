package br.lucasdemartha.cursoappium.page;

import org.openqa.selenium.By;

import br.lucasdemartha.cursoappium.core.BasePage;

public class AlertaPage extends BasePage{

    public void clicarAlertaConfirm(){
        clicarPorTexto("ALERTA CONFIRM");
    }

    public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }

    public String obterTituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }
    
    public String obterMensagemAlerta(){
        return obterTexto(By.id("android:id/message"));
    }

    public void confirmar(){
        clicarPorTexto("CONFIRMAR");
    }

    public String obterMensagemAlertaConfirmado(){
        return obterTexto(By.id("android:id/message"));
    }

    public void sair(){
        clicarPorTexto("SAIR");
    }

    public void clicarForaCaixa(){
        tap(100, 150);
    }

}
