package br.sp.vinilourenco.pages;

import br.sp.vinilourenco.core.BasePage;
import org.openqa.selenium.By;

import static br.sp.vinilourenco.core.DriverFactory.*;

public class LoginPage extends BasePage {

    public void acessarTelaInicial() {
        getDriver().get("https://seubarriga.wcaquino.me/");
    }

    public void setEmail(String email) {
        escrever("email", email);
    }

    public void setSenha(String senha) {
        escrever("senha", senha);
    }

    public void entrar() {
        clicarBotaoPorTexto("Entrar");
    }

    public void logar(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        entrar();
    }
}
