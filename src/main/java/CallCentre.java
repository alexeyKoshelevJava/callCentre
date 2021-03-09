import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCentre extends Thread {
    private static final int MAX = 10000000;
    private static final int MIN = 1000000;
    private static final int limiter = 15;


    Queue<Integer> queue = new LinkedBlockingQueue<>();

    public void addCall() {

        for (int i = 0; i < limiter; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            int randomNumber = random.nextInt((MAX - MIN) + 1) + MIN;
            queue.add(randomNumber);

            System.out.println(" Я АТС " + " добавил " + randomNumber);
        }
    }

    public void takeCall() {
        while (!isInterrupted()) {



                if (queue.peek() == null) {
                    System.out.println(Thread.currentThread() + " Жду звонка");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

                } else {


                    System.out.println(" я " + Thread.currentThread() + " взял звонок " + queue.poll());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
    }








