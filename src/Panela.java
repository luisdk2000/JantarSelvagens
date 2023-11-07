public class Panela {
    private int disponivel;
    private int m;

    public Panela(int m) {
        this.disponivel = 0;
        this.m = m;
    }

    public int getComida() {
        return this.disponivel -= 1;
    }

    public void reabastecer(int m) {
        this.disponivel += m;
    }

    public boolean temComida() {
        return this.disponivel > 0;
    }

    public int getM() {
        return m;
    }

    public int getDisponivel() {
        return this.disponivel;
    }
}
