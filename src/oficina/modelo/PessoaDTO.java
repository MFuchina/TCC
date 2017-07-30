package oficina.modelo;

public class PessoaDTO {

    private String nome, email;
    private int CPF_CNPJ, telefone, codigo;

    public PessoaDTO(String nome, String email, int CPF_CNPJ, int telefone, int codigo) {
        this.nome = nome;
        this.email = email;
        this.CPF_CNPJ = CPF_CNPJ;
        this.telefone = telefone;
        this.codigo = codigo;
    }

    public int getCodigo(int codigo) {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(int CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

}
