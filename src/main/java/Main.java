public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Рабочий день кол центра начался! Принимаю звонки!");
        CallCentre callCentre = new CallCentre();
        Thread thread = new Thread(callCentre::addCall);


        Thread thread1 = new Thread(callCentre::takeCall, "Я телефонист 1");

        Thread thread2 = new Thread( callCentre::takeCall, "Я телефонист 2");
        Thread thread3 = new Thread(callCentre::takeCall, "Я телефонист 3");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(30000);
        System.out.println("Рабочий день закончен");


      thread.interrupt();
      thread1.interrupt();
      thread2.interrupt();
      thread3.interrupt();


    }
}
