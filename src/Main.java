import java.util.concurrent.Semaphore;
public class Main {

    public static void main(String[] args) {
        int m = 3;
        Semaphore comer = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        Semaphore reabastecer = new Semaphore(0);

        Panela panela = new Panela(m);
        Cozinheiro cozinheiro = new Cozinheiro(reabastecer, comer, panela);
        Selvagem s0 = new Selvagem(0, mutex, comer, reabastecer, panela);
        Selvagem s1 = new Selvagem(1, mutex, comer, reabastecer, panela);
        Selvagem s2 = new Selvagem(2, mutex, comer, reabastecer, panela);
        Selvagem s3 = new Selvagem(3, mutex, comer, reabastecer, panela);
        Selvagem s4 = new Selvagem(4, mutex, comer, reabastecer, panela);
        Selvagem s5 = new Selvagem(5, mutex, comer, reabastecer, panela);

        cozinheiro.start();
        s0.start();
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
    }
}