package automatizado.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.pageObject.LoginPO;

//Ordem de execução dos metodos,para que eles não sejam executados aleatoriamente
//Esse name_ascending é pra que os testes sejam executados de acordo com os nomes dos métodos (já que antes de cada nome
//do método nós colocamos o TC001 - que se trata do número daquele teste/método)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTeste extends BaseTest {
    
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTeste(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveSerPossivelFazerLoginComEmailESenhaVazios(){
        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveSerPossivelFazerLoginComSenhaVaziaEEmailPreenchido(){
        loginPage.executarAcaoDeLogar("admin@admin.com","");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveSerPossivelFazerLoginComEmailVazioESenhaPreenchida(){
        loginPage.executarAcaoDeLogar("", "senhaTeste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC004_naoDeveSerPossivelFazerLoginComEmaileSenhaNaoExistentes(){
        loginPage.executarAcaoDeLogar("kamilla@gmail.com", "senhaTeste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC005_naoDeveSerPossivelFazerLoginComEmailExistenteESenhaNaoExistente(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "senhaTeste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    
    @Test
    public void TC006_naoDeveSerPossivelFazerLoginComSenhaExistenteEEmailNaoExistente(){
        loginPage.executarAcaoDeLogar("kamilla@gmail.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC007_deveSerPossivelFazerLogin(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        assertEquals(loginPage.obterTituloDaPagina(),"Controle de Produtos");
    }

}

