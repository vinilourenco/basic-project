package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.core.Properties;
import br.sp.vinilourenco.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();

    @Test
    public void testSaldoConta() {
        Assert.assertEquals("500.00", page.obterSaldoConta(Properties.NOME_CONTA_ALTERADA));
    }
}
