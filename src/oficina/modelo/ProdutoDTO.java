package oficina.modelo;

public class ProdutoDTO {

    private String nome, marca;
    private float precoUnit, preco;
    private int cod, qnt;

    public Object[] getLinhaTabelaConsulta() {
        Object[] retorno = {this.cod, this.nome, this.marca, this.precoUnit};
        return retorno;
    }
    
    public Object[] getLinha() {
        Object[] retorno = {this.qnt, this.nome, this.precoUnit, this.preco};
        return retorno;
    }
    
    public ProdutoDTO(int cod, String nome, String marca, float preco) {
        this.cod = cod;
        this.nome = nome;
        this.marca = marca;
        this.precoUnit = preco;
    }
    
    public ProdutoDTO(int qnt, String nome, float preco) {
        this.qnt = qnt;
        this.nome = nome;
        this.precoUnit = preco;
    }

    public ProdutoDTO() {
        this.cod = 0;
        this.qnt = 0;
        this.nome = "";
        this.marca = "";
        this.precoUnit = (float) 0.0;
    }

    public float getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }
    
    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
