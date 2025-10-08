package entities;

public class Points {
    private int valor = 0;

    public Points() {
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void addValor(int valor) {
        this.valor += valor;
    }

    public void resetAgain(){
        valor = 0;
    }
}
