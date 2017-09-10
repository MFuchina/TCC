package oficina.modelo;

public class ServicoDTO {
    private int cod;
    private String nome;
    private float preco;

    public ServicoDTO(int cod, String nome, float preco) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        
    }

    public ServicoDTO() {
        this.cod = 0;
        this.nome = "";
        this.preco = (float) 0.0;
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
