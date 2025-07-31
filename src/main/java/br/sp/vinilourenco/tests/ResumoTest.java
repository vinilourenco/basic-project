package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.core.DriverFactory;
import br.sp.vinilourenco.pages.MenuPage;
import br.sp.vinilourenco.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

import static br.sp.vinilourenco.core.DriverFactory.*;

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

    @Test
    public void testResumoMensal() {
        menuPage.acessarTelaResumo();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    }
}
