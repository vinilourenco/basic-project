package br.sp.vinilourenco.suites;

import br.sp.vinilourenco.core.DriverFactory;
import br.sp.vinilourenco.pages.LoginPage;
import br.sp.vinilourenco.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})
public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializa() {
        page.acessarTelaInicial();
        page.setEmail("vinicius_lourenco@outlook.com");
        page.setSenha("@Bininhaum19xx");
        page.entrar();
    }

    @AfterClass
    public static void finaliza() {
        DriverFactory.killDriver();
    }
}
