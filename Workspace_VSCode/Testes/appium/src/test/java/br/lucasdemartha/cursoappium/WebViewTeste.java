package br.lucasdemartha.cursoappium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;
import br.lucasdemartha.cursoappium.page.WebViewPage;

public class WebViewTeste extends BaseTeste{

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();
    
    @Test
	public void deveFazerLogin(){
		//acessar o menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("");
		
		//senha
		page.setSenha("");
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, Lucas!", page.getMensagem());
	}
	
	@After
	public void tearDown(){
		page.sairContextoWeb();
	}
    
}
