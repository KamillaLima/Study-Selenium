package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BateTest {
    //Essa classe aqui é pra basicamente iniciar o nosso drive ali
    //do google chrome
    protected static WebDriver driver;
    //Só os filhos que vão acessar
    private static final String URL_BASE = "https://www.google.com/" ;
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";
 
    @BeforeClass
    //BeforeClass : Antes de rodar qualquer método de teste,o beforeClasse
    //é chamado primeiro!
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    //Fechando o chrome após terminar os testes
    @AfterClass
    //AfterClass : Depois de finalizar todos os métodos de teste, o afterClass
    //é chamado por final
    public static void finalizar(){
        driver.quit();
    }
}
