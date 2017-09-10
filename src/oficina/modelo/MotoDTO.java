package oficina.modelo;

public class MotoDTO {

    private String marca, modelo, chassi, placa, cor;
    private int cod_moto, cod_dono, ano_modelo, ano_Fabr;

    public MotoDTO(int cod_moto, int cod_dono, String placa, String modelo, String cor, String marca, String chassi, int ano_modelo, int ano_Fabr) {
        this.cod_moto = cod_moto;
        this.cod_dono = cod_dono;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.chassi = chassi;
        this.ano_modelo = ano_modelo;
        this.ano_Fabr = ano_Fabr;
    }

    public MotoDTO() {
        this.cod_moto = 0;
        this.cod_dono = 0;
        this.placa = "";
        this.modelo = "";
        this.cor = "";
        this.marca = "";
        this.chassi = "";
        this.ano_modelo = 0;
        this.ano_Fabr = 0;
    }

    public int getCod_moto() {
        return cod_moto;
    }

    public void setCod_moto(int cod_moto) {
        this.cod_moto = cod_moto;
    }

    public int getCod_dono() {
        return cod_dono;
    }

    public void setCod_dono(int cod_dono) {
        this.cod_dono = cod_dono;
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
