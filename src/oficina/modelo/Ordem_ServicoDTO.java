package oficina.modelo;

import java.util.Date;

public class Ordem_ServicoDTO {
    private int cod_Ordem_Servico;
    private Date data;
    private String statusDaOS;

    public Ordem_ServicoDTO(int cod_Ordem_Servico, Date data, String statusDaOS) {
        this.cod_Ordem_Servico = cod_Ordem_Servico;
        this.data = data;
        this.statusDaOS = statusDaOS;
    }

    public int getCod_Ordem_Servico() {
        return cod_Ordem_Servico;
    }

    public void setCod_Ordem_Servico(int cod_Ordem_Servico) {
        this.cod_Ordem_Servico = cod_Ordem_Servico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
