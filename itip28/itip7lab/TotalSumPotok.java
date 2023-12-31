public class TotalSumPotok {
    public static void main(String[] args) throws InterruptedException {
        int[] gav = {1, 2, 3, 4, 5, 6};
        int[] sum12 = new int[2];
        Thread thread1 = new Thread(new ArraySumCalculator(gav, 0, gav.length / 2, sum12, 0));
        thread1.start();
        Thread thread2 = new Thread(new ArraySumCalculator(gav, gav.length / 2, gav.length, sum12, 1));
        thread2.start();
        thread1.join();
        thread2.join();
        int totalSum = sum12[0] + sum12[1];
        System.out.println("total " + totalSum);
    }
}
class ArraySumCalculator implements Runnable {
    private int[] gav;
    private int start;
    private int end;
    private int[] sum12;
    private int ind;
    public ArraySumCalculator(int[] gav, int start, int end, int[] sum12, int ind) {
        this.gav = gav;
        this.start = start;
        this.end = end;
        this.sum12 = sum12;
        this.ind = ind;
    }
    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += gav[i];
        }
        sum12[ind] = sum;
    }
}