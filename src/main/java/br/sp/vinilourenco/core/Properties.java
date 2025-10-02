package br.sp.vinilourenco.core;

public class Properties {

    public static boolean FECHAR_BROWSER = false;

    public static Browser browser = Browser.CHROME;

    public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();

    public enum Browser {
        CHROME,
        FIREFOX
    }
}
