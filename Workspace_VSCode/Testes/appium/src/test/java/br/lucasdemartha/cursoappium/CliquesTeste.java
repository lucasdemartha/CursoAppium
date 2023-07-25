package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.CliquesPage;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class CliquesTeste extends  BaseTeste{

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void setup(){
        //acessar menu
        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){
        //clicar botao longo
        page.cliqueLongo();

        //verificar texto
        Assert.assertEquals("Clique Longo", page.obterTextoCampo());

    }

    @Test
    public void deveRealizarCLiqueDuplo(){
        //clicar botao duplo
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");

        //verificar texto
        Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
    }
    
}
