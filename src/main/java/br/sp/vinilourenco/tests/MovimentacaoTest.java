package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.pages.MenuPage;
import br.sp.vinilourenco.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void testInserirMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao("30/07/2025");
        movPage.setDataPagamento("31/07/2025");
        movPage.setDescricao("Movimentação de Teste");
        movPage.setInteressado("InteressadoQualquer");
        movPage.setValor("500");
        movPage.setConta("Conta do Teste Alterada");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }
}
