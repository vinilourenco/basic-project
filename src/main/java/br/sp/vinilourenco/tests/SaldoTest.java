package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.core.Properties;
import br.sp.vinilourenco.pages.HomePage;
import br.sp.vinilourenco.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void testSaldoConta() {
        menu.acessarTelaPrincipal();
        Assert.assertEquals("500.00", page.obterSaldoConta(Properties.NOME_CONTA_ALTERADA));
    }
}
