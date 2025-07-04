package br.sp.vinilourenco.pages;

import br.sp.vinilourenco.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever("nome", nome);
    }

    public void salvar() {
        clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public void clicarAlterarConta(String contaDoTeste) {
        obterCelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class = 'glyphicon glyphicon-edit']")).click();
    }
}
