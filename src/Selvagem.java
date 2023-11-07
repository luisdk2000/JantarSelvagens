import java.util.concurrent.Semaphore;
import java.lang.Thread;

public class Selvagem extends Thread {
    private Semaphore mutex, comer, reabastecer;
    private Panela panela;
    private int id;

    public Selvagem(int id, Semaphore mutex, Semaphore comer, Semaphore reabastecer, Panela panela) {
        this.id = id;
        this.mutex = mutex;
        this.comer = comer;
        this.reabastecer = reabastecer;
        this.panela = panela;
    }

    public void comer(int comidaRestante) throws InterruptedException {
        System.out.println("Selvagem " + this.id + " está comendo. A panela tem " + comidaRestante + " restante");
        Thread.sleep(1000);
    }

    public void run() {
        while (true) {
            try {
                this.mutex.acquire();

                if (!this.panela.temComida()) {
                    System.out.println("Selvagem " + this.id + " não encontrou comida!");

                    this.reabastecer.release();
                    this.comer.acquire();
                }

                int comidaRestante = this.panela.getComida();
                this.mutex.release();
                this.comer(comidaRestante);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
