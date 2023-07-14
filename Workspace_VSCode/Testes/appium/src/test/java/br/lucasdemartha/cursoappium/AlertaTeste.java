package br.lucasdemartha.cursoappium;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.AlertaPage;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class AlertaTeste extends BaseTeste{

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        //Acessar menu Alerta
        menu.acessarAlerta();
    }

    @Test
    public void deveConfirmarAlerta(){
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

    @Test
    public void deveClicarForaAlerta(){
        //clicar em alerta confirm
        page.clicarAlertaSimples();

        //clicar fora da caixa
        page.clicarForaCaixa();

        //verificar que a mensagem nao esta presente
        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
    
}
