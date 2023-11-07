import java.util.concurrent.Semaphore;

public class Cozinheiro extends Thread {
    private Semaphore reabastecer, comer;
    private Panela panela;

    public Cozinheiro(Semaphore reabastecer, Semaphore comer, Panela panela) {
        this.reabastecer = reabastecer;
        this.comer = comer;
        this.panela = panela;
    }

    public void reabastecerPanela(int m) {
        System.out.println("O cozinheiro acordou!");
        this.panela.reabastecer(m);
        System.out.println("A panela agora está com comida novamente!");
    }

    public void run() {
        while (true) {
            try {
                this.reabastecer.acquire();
                this.reabastecerPanela(this.panela.getM());
                this.comer.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
