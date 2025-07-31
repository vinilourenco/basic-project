package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.pages.MenuPage;
import br.sp.vinilourenco.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {
    private MenuPage menuPage= new MenuPage();
    private ResumoPage resumoPage= new ResumoPage();

    @Test
    public void testExcluirMovimentacao() {
        menuPage.acessarTelaResumo();
        resumoPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!",
                resumoPage.obterMensagemSucesso());
    }
}
