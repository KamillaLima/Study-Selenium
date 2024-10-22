package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.pageObject.ControleDeProdutoPO;
import automatizado.pageObject.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{
    
    private static LoginPO loginPage;
    //Preciso dele já que preciso estar logado para conseguir
    //Cadastrar um produto
    private  static ControleDeProdutoPO controleDeProdutoPage;

    @BeforeClass
    public static void prepararTeste(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleDeProdutoPage.obterTituloDaPagina(),"Controle de Produtos");
    }

    @Test
    public void TC001_DeveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        // TODO: Remover esse duplo clique assim que o sistema for corrigido.
        controleDeProdutoPage.buttonAdicionar.click();
        controleDeProdutoPage.buttonAdicionar.click();
        String titulo = controleDeProdutoPage.tituloModal.getText();
        assertEquals("Produto",titulo);
        // TODO: Remover esse duplo clique assim que o sistema for corrigido.
        controleDeProdutoPage.buttonSair.click();
        controleDeProdutoPage.buttonSair.click();
    }

    @Test
    public void TC002_NaoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleDeProdutoPage.buttonAdicionar.click();
        String titulo = controleDeProdutoPage.tituloModal.getText();
        assertEquals("Produto",titulo);
        controleDeProdutoPage.cadastrarProduto("0001", "martelo", 10, 30.00, "");
        String mensagem = controleDeProdutoPage.spanMensagem.getText();
        assertEquals("Todos os campos são obrigatórios para o cadastro!",mensagem);
        controleDeProdutoPage.buttonSair.click();
    }
    
    @Test
    public void TC003_DeveSerPossivelCadastrarUmProdutoComTodosOsCamposPreenchidos(){
        controleDeProdutoPage.buttonAdicionar.click();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        produtoBuilder.builder();
        //É aquui no builder que acontece a ação de criar/salvar o produto
    }





}
