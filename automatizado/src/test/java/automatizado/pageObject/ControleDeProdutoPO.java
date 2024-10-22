package automatizado.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO{

    @FindBy(id="btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css="ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css="div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id="codigo")
    public WebElement inputCodigo;

    @FindBy(id="nome")
    public WebElement inputNome;

    @FindBy(id="quantidade")
    public WebElement inputQuantidade;

    @FindBy(id="valor")
    public WebElement inputValor;

    @FindBy(id="data")
    public WebElement inputDataCadastro;

    @FindBy(id="btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id="btn-sair")
    public WebElement buttonSair;

    @FindBy(id="mensagem")
    public WebElement spanMensagem;

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }

    public void cadastrarProduto(String codigo , String nome , Integer quantidade , 
    Double valor , String data){
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade.toString());
        escrever(inputValor, valor.toString());
        escrever(inputDataCadastro, data);
        buttonSalvar.click();
    }

    
    public void cadastrarProduto(ProdutoBuilder produtoBuilder){
        escrever(inputCodigo, produtoBuilder.codigo);
        escrever(inputNome, produtoBuilder.nome);
        escrever(inputQuantidade, produtoBuilder.quantidade.toString());
        escrever(inputValor, produtoBuilder.valor.toString());
        escrever(inputDataCadastro, produtoBuilder.data);
        buttonSalvar.click();
    }


}
