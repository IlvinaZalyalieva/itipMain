public class SrZn {
    public static void main(String[] args) {
        String[] array = {"1","w", "3", "5", "6"};
        int len = 5;
        int sum = 0;
        for (int i = 0; i < (len+1); i++) {
            try {
                sum += Integer.parseInt(array[i]);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                len--;
            }
        }
        System.out.println((double) sum/len);
    }
}
