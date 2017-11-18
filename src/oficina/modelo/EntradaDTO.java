package oficina.modelo;

public class EntradaDTO {

    private float valor;
    private String tipo, data;
    private int cod;

    public EntradaDTO(int cod, float valor, String tipo, String data) {
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
        this.cod = cod;
    }

    public EntradaDTO(float valor, String tipo, String data) {
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
    }

    public Object[] getLinhaTabela() {
        String tipoa = "", valors = "";
        switch (this.tipo) {
            case "D":
                tipoa = "Dinheiro";
                break;
            case "C":
                tipoa = "Cartão";
                break;
            case "CQ":
                tipoa = "Cheque";
                break;
        }
        valors = ("R$ "+String.valueOf(this.valor));
        Object[] retorno = {this.cod, valors, tipoa};
        return retorno;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
