package oficina.modelo;

public class ServicosDTO {
    private String nome;
    private float preco;
    private int cod_Servico;

    public ServicosDTO(String nome, float preco, int cod_Servico) {
        this.nome = nome;
        this.preco = preco;
        this.cod_Servico = cod_Servico;
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

    public int getCod_Servico() {
        return cod_Servico;
    }

    public void setCod_Servico(int cod_Servico) {
        this.cod_Servico = cod_Servico;
    }
    
}
