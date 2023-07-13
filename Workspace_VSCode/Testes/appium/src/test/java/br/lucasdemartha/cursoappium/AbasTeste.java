package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.AbasPage;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class AbasTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private AbasPage page = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        //acessar menu abas
        menu.acessarAbas();

        //verificar que esta na aba 1
        Assert.assertTrue(page.isAba1());

        //acessar aba 2

        page.selecionarAba2();

        //verificar que esta na aba 2

        Assert.assertTrue(page.isAba2());
    }
    
}
