package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;
import br.lucasdemartha.cursoappium.page.SwipeListPage;

public class SwipeElementTeste extends BaseTeste{

    private MenuPage menu = new MenuPage();
    private SwipeListPage page = new SwipeListPage();

    @Test
    public void deveResolverDesafio(){
        //clicar swipe list
        menu.clicarSwipeList();

        //op1 para direita
        page.swipeElementRight("Opção 1");

        //op1 + botao
        page.clicarBotaoMais();

        //verificar op1 + botao
        Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

        //op4 para direita
        page.swipeElementRight("Opção 4");

        //op4 + botao
        page.clicarPorTexto("(-)");

        //verificar op4 + botao
        Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

        //op5 para esquerda
        page.swipeElementLeft("Opção 5 (-)");

        //op5 + botao
        Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));

    }
    
}
