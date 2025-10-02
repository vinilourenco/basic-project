package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.core.Properties;
import br.sp.vinilourenco.pages.ContasPage;
import br.sp.vinilourenco.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao() {
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta(Properties.NOME_CONTA_ALTERADA);
        Assert.assertEquals("Conta em uso na movimentações",
                contasPage.obterMensagemErro());
    }
}
