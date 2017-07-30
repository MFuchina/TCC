package oficina.modelo;

import java.util.Date;

public class OrcamentoDTO {
    private int cod_Orcamento;
    private Date data;

    public OrcamentoDTO(int cod_Orcamento, Date data) {
        this.cod_Orcamento = cod_Orcamento;
        this.data = data;
    }

    public int getCod_Orcamento() {
        return cod_Orcamento;
    }

    public void setCod_Orcamento(int cod_Orcamento) {
        this.cod_Orcamento = cod_Orcamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
