package java7.concurrent.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinMerge {

  private static class MergeSorter extends RecursiveAction {

    private static final long serialVersionUID = 1L;
	private int[] a;
    private int lo;
    private int hi;
    public MergeSorter(int[] a, int lo, int hi) {
      this.a = a;
      this.lo = lo;
      this.hi = hi;
    }

    @Override
    protected void compute() {
      int med = (hi + lo) / 2;
      if (hi - med > 0) {
        if (hi - lo < 40) {
          Arrays.sort(a, lo, hi + 1);
        } else {
          MergeSorter loTask = new MergeSorter(a, lo, med);
          MergeSorter hiTask = new MergeSorter(a, med + 1, hi);
          invokeAll(loTask, hiTask);
          loTask.join();
          hiTask.join();
          merge(a, lo, med, hi);
        }
      }
    }
  }

  public static void sort(int[] a) {
    new ForkJoinPool().invoke(new MergeSorter(a, 0, a.length - 1));
  }

  public static void sort(int[] a, int cores) {
    new ForkJoinPool(cores).invoke(new MergeSorter(a, 0, a.length - 1));
  }

  private static void merge(int[] a, int lo, int med, int hi) {
    int[] b = new int[hi - lo + 1];
    int i = lo;
    int j = med + 1;
    int k = 0;
    while (i <= med && j <= hi) {
      if (a[i] <= a[j]) {
        b[k++] = a[i++];
      } else {
        b[k++] = a[j++];
      }
    }
    while (i <= med) {
      b[k++] = a[i++];
    }
    while (j <= hi) {
      b[k++] = a[j++];
    }
    System.arraycopy(b, 0, a, lo, hi - lo + 1);
  }

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    System.out.println("N = " + N);
    int warmUpSize = Math.min(100000, N / 100);
    int[] original = fillRandom(N);

    sort(Arrays.copyOf(original, warmUpSize));
    for (int i = 1; i <= Runtime.getRuntime().availableProcessors(); i++) {
      int[] copy = Arrays.copyOf(original, original.length);
      long time = System.currentTimeMillis();
      sort(copy, i);
      System.out.println(i + " cores:\t" + (System.currentTimeMillis() - time));
    }

    Arrays.sort(Arrays.copyOf(original, warmUpSize));
    long time = System.currentTimeMillis();
    Arrays.sort(Arrays.copyOf(original, original.length));
    System.out.println("Lib:\t\t" + (System.currentTimeMillis() - time));
    
    Arrays.parallelSort(Arrays.copyOf(original, warmUpSize));
    time = System.currentTimeMillis();
    Arrays.parallelSort(Arrays.copyOf(original, original.length));
    System.out.println("Lib parallel:\t" + (System.currentTimeMillis() - time));
  }

  private static int[] fillRandom(int N) {
    Random r = new Random();
    int[] a = new int[N];
    for (int i = 0; i < a.length; i++) {
      a[i] = r.nextInt();
    }
    return a;
  }
}
