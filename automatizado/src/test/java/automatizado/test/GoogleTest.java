package automatizado.test;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.pageObject.GooglePO;



public class GoogleTest extends BateTest {

    private static GooglePO googlePage;
    @BeforeClass
    public static void prepararTeste(){
        googlePage = new GooglePO(driver);
    }
    @Test      //TC001 = TestCase001
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoSorvete(){
        //O nosso driver foi criado lá na classe BateTest
       //WebElement inputPesquisa = driver.findElement(By.name("q"));
       //Quando você inspeciona a página do google,no input para você escrever
       //o que você quer pesquisar,eles usam o name = "Q" no input
       //Então aqui nós estamos procurando esse input
        //inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
        //Aqui nós estamos dizendo que dentro do input nós queremos que seja 
        //escrito a palavra sorvete e que logo após a tecla Enter seja clicada

        /*Depois da criação dos pages,não é mais necessário fazer da forma acima**/
        googlePage.pesquisar("sorvete");
       
    }
}
