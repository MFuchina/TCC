package oficina.modelo;

import java.util.Date;

public class OrcamentoDTO {

    private int cod_Orcamento;
    private Date data;
    private float total;
    private int cod_cliente, cod_moto;

    public OrcamentoDTO(int cod_Orcamento, int cod_cliente, int cod_moto, Date data, float total) {
        this.cod_Orcamento = cod_Orcamento;
        this.cod_cliente = cod_cliente;
        this.cod_moto = cod_moto;
        this.data = data;
        this.total = total;
    }

    public OrcamentoDTO() {
        this.cod_Orcamento = 0;
        this.cod_cliente = 0;
        this.cod_moto = 0;
        this.data = null;
        this.total = (float) 0.0;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_moto() {
        return cod_moto;
    }

    public void setCod_moto(int cod_moto) {
        this.cod_moto = cod_moto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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
