package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {
    //Aqui nessa classe temos tudo que é necessário
    //para as tarefas que fazemos no google
    @FindBy(name = "q")
    public WebElement inputPesquisa;

    /**
     * Construtor para criação da pagina do Google.
     * @param driver Driver da pagina do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Metodo que irá efetuar uma pesquisa no google baseando no texto informado e concluindo com enter.
     * @param texto Texto a ser pesquisado.
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }


}
