import java.security.SecureRandom;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        String s1 = "Donald";
        boolean hasDuplicates1 = duplicateChars("Donald");
        System.out.println("Повтор " + hasDuplicates1);
        System.out.println("1......");
        String initials = getInitials("Ryan Gosling");
        System.out.println("Инициалы " + initials);
        System.out.println("2......");
        int[] arr = {44, 32, 86, 19};
        int difference = differenceEvenOdd(arr);
        System.out.println("Разницв  " + difference);
        int[] arr2 = {22, 50, 16, 63, 31, 55};
        int difference2 = differenceEvenOdd(arr2);
        System.out.println("Разница" + difference2);
        System.out.println("3......");
        int[] arrr = {1, 2, 3, 4, 5};
        boolean result = equalToAvg(arrr);
        System.out.println("Среднее арифметичское есть " + result);
        int[] arrr2 = {1, 2, 3, 4, 6};
        boolean result2 = equalToAvg(arrr2);
        System.out.println("Среднее арифметичское есть" + result2);
        System.out.println("4......");
        int[] arrind = {1, 2, 3};
        int[] resultind = indexMult(arrind);
        System.out.println("Индексы " + Arrays.toString(resultind));
        int[] arrind2 = {3, 3, -2, 408, 3, 31};
        int[] resultind2 = indexMult(arrind2);
        System.out.println("Индексы " + Arrays.toString(resultind2));
        System.out.println("5......");
        String reversed1 = reverse("Hello World");
        System.out.println("Строка в обратном порядке: " + reversed1.replaceAll("\\s", ""));
        System.out.println("6......");
        int trib1 = Tribonacci(7);
        System.out.println("Число Трибоначчи " + trib1);
        System.out.println("7......");
        String q = pseudoHash(5);
        System.out.println("квази-хэш: " + q);
        System.out.println("8......");
        String ans = botHelper("Hello, I’m under the water, please help, me");
        System.out.println(ans);
        System.out.println("9......");
        boolean isAnagram = isAnagram("eleven plus two", "twelve plus one");
        if (isAnagram) {
            System.out.println("Строки являются анаграммами.");
        } else {
            System.out.println("Строки не являются анаграммами.");
        }
    }

    public static boolean duplicateChars(String s) {
        s = s.toLowerCase();
        boolean[] list = new boolean[260];
        for (int i = 0; i < s.length(); i++) {
            int symb = s.charAt(i);
            if (list[symb]) {
                return true;
            }
            list[symb] = true;
        }
        return false;
    }

    public static String getInitials(String full) {
        String[] ns = full.split(" ");
        StringBuilder initial = new StringBuilder();
        for (String i : ns)
            initial.append(i.charAt(0));
        String initials = initial.toString().replaceAll("\\s", "");
        return initials;
    }

    public static int differenceEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }
        int mod = Math.abs(even - odd);
        return mod;
    }

    public static boolean equalToAvg(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double srar = (double) sum / arr.length;
        for (int num : arr) {
            if (num == srar) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = arr[i] * i;
        }
        return result;
    }

    public static String reverse(String s) {
        int length = s.length();
        StringBuilder reversed = new StringBuilder(length);

        for (int i = length - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }

    public static int Tribonacci(int n) {
        int[] trib = new int[n];
        trib[0] = 0;
        trib[1] = 0;
        trib[2] = 1;
        for (int i = 3; i < n; i++) {
            trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
        }
        return trib[n - 1];
    }

    public static String pseudoHash(int length) {
        String symb = "0123456789abcdef";
        StringBuilder hash = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int ind = random.nextInt(symb.length());
            hash.append(symb.charAt(ind));
        }
        return hash.toString();
    }

    public static String botHelper(String s) {
        s = s.toLowerCase();
        String key = "help";
        String[] array = s.split(" ");
        for (String word : array) {
            word = word.replaceAll("\\pP", "");
            if (word.equals(key)) {
                return "Calling";
            }
        }
        return "Wait";
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] l1 = str1.toCharArray();
        char[] l2 = str2.toCharArray();
        Arrays.sort(l1);
        Arrays.sort(l2);
        return Arrays.equals(l1, l2);
    }

}
