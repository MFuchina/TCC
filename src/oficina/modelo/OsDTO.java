package oficina.modelo;

import java.util.Date;

public class OsDTO {
    private int codOs, cod_cliente, cod_moto;
    private Date data;
    private String statusOS;
    private float total;

    public OsDTO(int codOs, int cod_cliente, int cod_moto, Date data, String statusOS, float total) {
        this.codOs = codOs;
        this.cod_cliente = cod_cliente;
        this.cod_moto = cod_moto;
        this.data = data;
        this.statusOS = statusOS;
        this.total = total;
    }

    public OsDTO() {
        this.codOs = 0;
        this.cod_cliente = 0;
        this.cod_moto = 0;
        this.data = null;
        this.statusOS = "";
        this.total = (float) 0.0;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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

    public String getStatusOS() {
        return statusOS;
    }

    public void setStatusOS(String statusOS) {
        this.statusOS = statusOS;
    }

    public int getCodOs() {
        return codOs;
    }

    public void setCodOs(int codOs) {
        this.codOs = codOs;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
