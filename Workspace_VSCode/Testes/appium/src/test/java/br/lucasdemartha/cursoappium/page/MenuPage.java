package br.lucasdemartha.cursoappium.page;

import br.lucasdemartha.cursoappium.core.BasePage;

public class MenuPage extends BasePage {


    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlerta(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }

}
