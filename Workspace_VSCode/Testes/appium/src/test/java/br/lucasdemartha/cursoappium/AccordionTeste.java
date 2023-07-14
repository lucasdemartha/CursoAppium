package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.page.AccordionPage;
import br.lucasdemartha.cursoappium.page.MenuPage;

public class AccordionTeste {
    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        //acessar menu accordion
        menu.acessarAccordion();

        //clicar opcao 1
        page.selecionarOp1();

        //verificar texto opcao 1
        Assert.assertTrue(page.obterValorOp1().equals("Esta é a descrição da opção 1"));
    }
}
