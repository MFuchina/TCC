package oficina.modelo;

public class ClienteDTO extends PessoaDTO {

    public ClienteDTO(String nome, String email, int CPF_CNPJ, int telefone, int codigo) {
        super(nome, email, CPF_CNPJ, telefone, codigo);
    }
}
