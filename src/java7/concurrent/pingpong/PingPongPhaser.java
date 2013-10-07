package java7.concurrent.pingpong;

import java.util.concurrent.Phaser;

public class PingPongPhaser {
  static final Phaser p = new Phaser(1);

  public static void main(String[] args) {
    t("ping");
    t("pong");
  }

  private static void t(final String msg) {
    new Thread() {
      @Override
      public void run() {
        while (true) {
          System.out.println(msg);
          p.awaitAdvance(p.arrive() + 1);
        }
      }
    }.start();
  }
}
