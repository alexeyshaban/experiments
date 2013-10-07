package java7.concurrent.pingpong;

public class PingPong {

  private volatile boolean ponged = true;

  public synchronized void ping() throws InterruptedException {
    if (ponged) {
      System.out.print("Ping ");
      ponged = false;
    } else {
      wait();
    }
    notify();
  }

  public synchronized void pong() throws InterruptedException {
    if (!ponged) {
      System.out.println("Pong ");
      ponged = true;

    } else {
      wait();
    }
    notify();
  }

  public static void main(String arg[]) {
    final PingPong pingpong = new PingPong();
    new Thread() {
      @Override
      public void run() {
        while (true)
          try {
            pingpong.ping();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
      }

    }.start();

    new Thread() {
      @Override
      public void run() {
        while (true)
          try {
            pingpong.pong();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
      }
    }.start();
  }

}
