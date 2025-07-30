package br.sp.vinilourenco.pages;

import br.sp.vinilourenco.core.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao(String data) {
        escrever("data_transacao", data);
    }

    public void setDataPagamento(String data) {
        escrever("data_pagamento", data);
    }

    public void setDescricao(String descricao) {
        escrever("descricao", descricao);
    }

    public void setInteressado(String interessado) {
        escrever("interessado", interessado);
    }

    public void setValor(String valor) {
        escrever("valor", valor);
    }

    public void setConta(String conta) {
        selecionarCombo("conta", conta);
    }

    public void setStatusPago() {
        clicarRadio("status_pago");
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
