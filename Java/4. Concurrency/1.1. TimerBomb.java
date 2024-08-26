class CountDown implements Runnable {

    String[] timeStr = {"Zero", "One", "Two", "Three", "Four"};

    @Override
    public void run() {
        for (int i = 4; i >= 0; i--) {
            try {
                System.out.println(timeStr[i]);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class TimerBomb {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new CountDown());
        System.out.println("Starting count down");
        t.start();
        t.join();
        System.out.println("Boom!!");
    }
}