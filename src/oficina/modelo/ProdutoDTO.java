package oficina.modelo;

public class ProdutoDTO {

    private String nome, marca;
    private float preco;
    private int cod;

    public Object[] getLinhaTabela() {
        Object[] retorno = {this.cod, this.nome, this.marca, this.preco};
        return retorno;
    }
    
    public ProdutoDTO(int cod, String nome, String marca, float preco) {
        this.cod = cod;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public ProdutoDTO() {
        this.cod = 0;
        this.nome = "";
        this.marca = "";
        this.preco = (float) 0.0;
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
