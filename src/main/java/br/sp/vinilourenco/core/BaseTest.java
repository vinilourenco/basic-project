package br.sp.vinilourenco.core;

import br.sp.vinilourenco.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.sp.vinilourenco.core.DriverFactory.getDriver;
import static br.sp.vinilourenco.core.DriverFactory.killDriver;

public class BaseTest {

    private LoginPage page = new LoginPage();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void inicializa() {
        page.acessarTelaInicial();
        page.setEmail("vinicius_lourenco@outlook.com");
        page.setSenha("@Bininhaum19xx");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File archive = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archive, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpg"));

        if (Properties.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
