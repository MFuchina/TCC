package oficina.modelo;

public class ClienteDTO {

    private int codigo;
    private String nome, email, sexo, CPF_CNPJ, telefone;

    public ClienteDTO(int codigo, String nome, String email, String sexo, String CPF_CNPJ, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.CPF_CNPJ = CPF_CNPJ;
        this.telefone = telefone;
    }

    public ClienteDTO() {
        this.codigo = 0;
        this.nome = "";
        this.email = "";
        this.sexo = "";
        this.CPF_CNPJ = "";
        this.telefone = "";
    }

    public Object[] getLinhaTabela() {
        Object[] retorno = {this.codigo, this.nome, this.CPF_CNPJ, this.telefone};
        return retorno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCodigo() {
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

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
