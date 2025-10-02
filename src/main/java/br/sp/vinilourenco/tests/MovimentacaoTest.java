package br.sp.vinilourenco.tests;

import br.sp.vinilourenco.core.BaseTest;
import br.sp.vinilourenco.core.Properties;
import br.sp.vinilourenco.pages.MenuPage;
import br.sp.vinilourenco.pages.MovimentacaoPage;
import br.sp.vinilourenco.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.sp.vinilourenco.utils.DataUtils.obterDataFormatada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void test1_InserirMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao(obterDataFormatada(new Date()));
        movPage.setDataPagamento(obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação de Teste");
        movPage.setInteressado("InteressadoQualquer");
        movPage.setValor("500");
        movPage.setConta(Properties.NOME_CONTA_ALTERADA);
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

    @Test
    public void test2_CamposObrigatorios() {
        menuPage.acessarTelaInserirMovimentacao();

        movPage.salvar();
        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void test3_InserirMovimentacaoFutura() {
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação de Teste");
        movPage.setInteressado("InteressadoQualquer");
        movPage.setValor("500");
        movPage.setConta(Properties.NOME_CONTA_ALTERADA);
        movPage.setStatusPago();
        movPage.salvar();

        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}
