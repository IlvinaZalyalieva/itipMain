public class Primes {
    public static void main(String[] args) {
        System.out.println("Простые числа меньше 100:");
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }}
    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }}
