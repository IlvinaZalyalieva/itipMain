public class MaxElem {
    public static void main(String[] args) throws InterruptedException {
        int[][] meow = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int max = Integer.MIN_VALUE;
        int countStr = meow.length;
        ElemFind[] MaxElem = new ElemFind[countStr];
        for (int i = 0; i < countStr; i++) {
            MaxElem[i] = new ElemFind(meow[i]);
            MaxElem[i].start();
        }
        for (int i = 0; i < countStr; i++) {
            MaxElem[i].join();
            int threadMax = MaxElem[i].getMax(); //  макс элем из потока
            if (threadMax > max) {
                max = threadMax;
            }
        }
        System.out.println("макс " + max);
    }
}
class ElemFind extends Thread {
    private int max;
    private int[] row;
    public ElemFind(int[] row) {
        this.max = Integer.MIN_VALUE;
        this.row = row;
    }
    @Override
    public void run() {
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }}
    public int getMax() {
        return max;
    }
}
