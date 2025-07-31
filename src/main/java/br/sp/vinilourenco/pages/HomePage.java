package br.sp.vinilourenco.pages;

import br.sp.vinilourenco.core.BasePage;

public class HomePage extends BasePage {

    public String obterSaldoConta(String nomeConta) {
        return obterCelula("Conta", nomeConta, "Saldo", "tabelaSaldo").getText();
    }
}
