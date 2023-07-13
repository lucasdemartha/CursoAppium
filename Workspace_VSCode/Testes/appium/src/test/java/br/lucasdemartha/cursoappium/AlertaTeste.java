package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.AlertaPage;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class AlertaTeste extends BaseTeste{

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Test
    public void deveConfirmarAlerta(){
        //acessar menu alerta
        menu.acessarAlerta();

        //clicar em alerta confirm
        page.clicarAlertaConfirm();

        //verificar os textos
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        //confirmar alerta
        page.confirmar();

        //verificar nova mensagem
        
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirmado", page.obterMensagemAlertaConfirmado());

        //sair
        page.sair();
    }
    
}
