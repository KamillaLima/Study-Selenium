package automatizado.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas PagesObjects.
 * Toda as pages devem ser herdadas desta classe.
*/
public abstract class BasePO {
                        // BasePO = Base Page Object
    /**Driver base que será usado pelas pages */
    //Responsável por linkar o chrome driver que foi instalado (ele tá na pasta resource no caso)
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos (PageFactory).
     * @param driver  Driver da página atual.
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        //O driver dessa classe (ali da linha 14) vai receber o driver
        //que está vindo como parâmetro
        PageFactory.initElements(driver, this);
    }


    public String obterTituloDaPagina(){
        return driver.getTitle();
        //Esse método será usado para ver se ele está fazendo o login corretamente quando
        //as infos estão todas corretas. Ele vai pegar o titulo da página para ver se 
        //quando as infos foram informadas corretamente, o usuário foi mandado para a página
        //de cadastro de produtos
    }
}
