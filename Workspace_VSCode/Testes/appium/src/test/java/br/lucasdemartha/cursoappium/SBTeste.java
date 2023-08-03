package br.lucasdemartha.cursoappium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.lucasdemartha.cursoappium.core.BaseTeste;
import br.lucasdemartha.cursoappium.page.MenuPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBContasPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBHomePage;
import br.lucasdemartha.cursoappium.page.SBPage.SBLoginPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBMenuPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBMovimentacaoPage;
import br.lucasdemartha.cursoappium.page.SBPage.SBResumoPage;

public class SBTeste extends BaseTeste{

    MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage menuSB = new SBMenuPage();
    private SBContasPage contas = new SBContasPage();
    private SBMovimentacaoPage mov = new SBMovimentacaoPage();
    private SBHomePage home = new SBHomePage();
    private SBResumoPage resumo = new SBResumoPage();

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

    @Test
    public void deveValidarInclusãoMov(){
        menuSB.acessarMovimentacoes();

        //validar descrição
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));

        //validar interessado
        mov.setDescricao("Desc");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));

        //validar valor
        mov.setInteressado("Inter");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));

        //validar conta
        mov.setValor("123");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));

        //validar conta
        mov.setConta("Conta para alterar");
        mov.salvar();
        Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));

    }

    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao(){
        //verificar saldo "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		menuSB.acessarResumo();
		
		//excluir Movimentacao 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//validar a mensagem "Movimentação removida com sucesso"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		
		//voltar home
		menuSB.acessarHome();
		
		//atualizar saldos
		esperar(1000);
		home.scroll(0.2, 0.9);
		
		//verificar saldo = -1000.00
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
    }
    
}
