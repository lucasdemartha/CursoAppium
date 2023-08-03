package br.lucasdemartha.cursoappium.page.SBPage;

import br.lucasdemartha.cursoappium.core.BasePage;

public class SBMenuPage extends BasePage{

    public void acessarContas(){
        clicarPorTexto("Contas");
    }

    public void acessarMovimentacoes(){
        clicarPorTexto("Mov...");
    }

    public void acessarResumo(){
        clicarPorTexto("Resumo");
    }

    public void acessarHome(){
        clicarPorTexto("Home");
    }
    
}
