package oficina.modelo;

public class ProdutoDTO {
    private String nome, marca;
    private float preco;
    private int cod_Barras;

    public ProdutoDTO(String nome, String marca, float preco, int cod_Barras) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.cod_Barras = cod_Barras;
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

    public int getCod_Barras() {
        return cod_Barras;
    }

    public void setCod_Barras(int cod_Barras) {
        this.cod_Barras = cod_Barras;
    }
    
}
