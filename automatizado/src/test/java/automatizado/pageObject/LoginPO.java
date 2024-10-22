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

    public void executarAcaoDeLogar(String email,String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();//para clicar no botão
    }

   


    
}
