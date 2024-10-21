package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(id = "senha")
    public WebElement inputSenha;
    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;
    @FindBy(id="mensagem")
    public WebElement spanMensagem;

    /*Construtor padrão para a criação de uma nova instância
    da página de login */ 
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem(){
        return spanMensagem.getText();
    }

    public void escrever(WebElement input,String texto){
        input.clear();
        //para não ter o risco de já ter alguma informação ali dentro do meu campo
        input.sendKeys(texto + Keys.TAB);
        //Com esse método escrever , independente de qual seja o input
        // que eu queira mudar,eu vou conseguir
    }

    public void executarAcaoDeLogar(String email,String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();//para clicar no botão
    }

    public String obterTituloDaPagina(){
        return driver.getTitle();
        //Esse método será usado para ver se ele está fazendo o login corretamente quando
        //as infos estão todas corretas. Ele vai pegar o titulo da página para ver se 
        //quando as infos foram informadas corretamente, o usuário foi mandado para a página
        //de cadastro de produtos
    }


    
}
