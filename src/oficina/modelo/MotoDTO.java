package oficina.modelo;

public class MotoDTO {
    private String marca, modelo, chassi, placa, cor;
    private int cod_moto, ano_modelo, ano_Fabr;

    public MotoDTO(String marca, String modelo, String chassi, String placa, String cor, int cod_moto, int ano_modelo, int ano_Fabr) {
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
        this.placa = placa;
        this.cor = cor;
        this.cod_moto = cod_moto;
        this.ano_modelo = ano_modelo;
        this.ano_Fabr = ano_Fabr;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(int ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public int getAno_Fabr() {
        return ano_Fabr;
    }

    public void setAno_Fabr(int ano_Fabr) {
        this.ano_Fabr = ano_Fabr;
    }
    
}
