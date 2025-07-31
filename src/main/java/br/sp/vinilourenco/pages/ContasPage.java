package br.sp.vinilourenco.pages;

import br.sp.vinilourenco.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever("nome", nome);
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarAlterarConta(String contaDoTeste) {
        obterCelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clicarExcluirConta(String contaDoTeste) {
        obterCelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
