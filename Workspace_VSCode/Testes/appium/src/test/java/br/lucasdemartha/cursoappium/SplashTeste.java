package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;
import br.lucasdemartha.cursoappium.page.SplashPage;

public class SplashTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){
        //acessar menu splash

        menu.acessarSplash();

        //verificar que o splash esta sendo exibido
        
        page.isTelaSplashVisivel();

        //aguardar saida do splash

        page.aguardarSplashSumir();

        //verificar que o formulario esta aparecendo

        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
    }
    
}
