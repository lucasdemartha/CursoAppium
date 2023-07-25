package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class SwipeTeste extends BaseTeste{

    private MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe(){
        //acessar menu
        menu.acessarSwipe();

        //verificar texto "a esquerda"
        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        //swipe para direita
        menu.swipeRight();

        //verificar texto "E veja se"
        Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

        //clicar botao direita
        menu.clicarPorTexto("›");

        //verificar texto "Chegar até o fim!"
        Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
    }
}
