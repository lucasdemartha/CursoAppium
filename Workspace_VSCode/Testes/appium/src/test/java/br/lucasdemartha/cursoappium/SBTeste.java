package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBContasPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBLoginPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBMenuPage;

public class SBTeste extends BaseTeste{

    MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage menuSB = new SBMenuPage();
    private SBContasPage contas = new SBContasPage();

    @Before
    public void setUp(){
        menu.acessarSBNativo();
        login.setEmail("lucasribm@gmail.com");
        login.setSenha("123mudar");
        login.entrar();
    }

    @Test
    public void deveInserirContaComSucesso(){
        //entrar em contas
        menuSB.acessarContas();

        //digitar nome conta
        contas.setConta("Conta de teste");

        //salvar
        contas.salvar();

        //verificar mensagem
        Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
        
    }

    @Test
	public void deveExcluirConta(){
		// entrar em contas
		menuSB.acessarContas();
		
		//clique longo na conta
		contas.selecionarConta("Conta mesmo nome");
		
		//ecluir
		contas.excluir();
		
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
    
}
