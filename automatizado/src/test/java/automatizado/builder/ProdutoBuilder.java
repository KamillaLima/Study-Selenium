package automatizado.builder;
import automatizado.pageObject.ControleDeProdutoPO;
public class ProdutoBuilder {

    public String codigo = "001";
    public String nome = "Produto padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "12/12/2024";
    private ControleDeProdutoPO controleDeProdutoPO;

    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    public void builder(){
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, quantidade.toString());
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, valor.toString());
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputDataCadastro, data);
        controleDeProdutoPO.buttonSalvar.click();
    }

    
}
