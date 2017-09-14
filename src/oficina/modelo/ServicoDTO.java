package oficina.modelo;

public class ServicoDTO {

    private int cod;
    private String nome, desc;
    private float preco;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object[] getLinhaTabela() {
        Object[] retorno = {this.cod, this.nome, this.preco, this.desc};
        return retorno;
    }

    public ServicoDTO(int cod, String nome, float preco, String desc) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.desc = desc;
    }

    public ServicoDTO() {
        this.cod = 0;
        this.nome = "";
        this.preco = (float) 0.0;
        this.desc = "";
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
