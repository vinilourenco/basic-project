package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.pages.ContasPage;
import br.sp.vinilourenco.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testInserirConta() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!",
                contasPage.obterMensagemSucesso());
    }

    @Test
    public void testAlterarConta() {
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Conta do Teste");
        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!",
                contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirContaMesmoNome() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!",
                contasPage.obterMensagemErro());
    }

    @Test
    public void testExcluirContaComMovimentacao() {
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta("Conta do Teste Alterada");
        Assert.assertEquals("Conta em uso na movimentações",
                contasPage.obterMensagemErro());
    }
}
