package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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
        assertEquals(titulo, "Produto");
    }

}
