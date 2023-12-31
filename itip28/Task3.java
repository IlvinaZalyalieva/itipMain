import java.util.*;


public class Task3 {
    public static void main(String[] args) {
        System.out.println("1-----------");
        String resultString = replaceVovels("apple");
        System.out.println(resultString);
        System.out.println("2-----------");
        String resultString2 = stringTransform("bookkeeper");
        System.out.println(resultString2);
        System.out.println("3-----------");
        boolean result3 = BlockkFit(1, 3, 5, 4, 5);
        System.out.println("Помещается в отверстие? " + result3);
        System.out.println("4-----------");
        boolean result4 = numCheck(243);
        System.out.println("Сумма квадратов цифр имеет ту же четность, что и число? " + result4);
        System.out.println("5-----------");
        int[] coefficients = {2, 5, 2}; // Пример коэффициентов a, b, c
        int result5 = countRoots(coefficients);
        System.out.println("Количество целочисленных корней: " + result5);
        System.out.println("6-----------");
        String[][] sData = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };
        List<String> result6 = salesData(sData);
        System.out.println(result6);
        System.out.println("7-----------");
        boolean result7 = validSplit("dog cad eish goose");
        System.out.println("Можно ли разбить предложение " + result7);
        System.out.println("8-----------");
        int[] sent = {-8, 1, 4, 2, 7, 1};
        int[] sent1 = {-8, 1, 4, 2, 7, 1};
        boolean result8 = waveForm(sent);
        System.out.println("Волнообразное? " + result8);
        System.out.println("9-----------");
        String result9 = String.valueOf(commonVovel("Hello world"));
        System.out.println(result9);
        System.out.println("10-----------");
        int[][] input = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        System.out.println(dataScience(input));
    }

    public static String replaceVovels(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if ("aeiouAEIOU".indexOf(currentChar) == -1) {
                result.append(currentChar);
            } else {
                result.append('*');
            }
        }
        return result.toString();
    }

    public static String stringTransform(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (i == input.length() - 1) {
                result.append(currentChar);
                break;
            }
            char nextChar = input.charAt(i + 1);
            if (Character.toLowerCase(currentChar) == Character.toLowerCase(nextChar)) {
                result.append("Double").append(currentChar);
                i += 1;
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static boolean BlockkFit(int a, int b, int c, int w, int h) {
        int[] toy = new int[]{a, b, c};
        int[] sides = new int[]{w, h};
        Arrays.sort(toy);
        Arrays.sort(sides);
        int minToy = toy[0];
        int midToy = toy[1];
        int minSide = sides[0];
        int maxSide = sides[1];
        return minSide >= minToy && maxSide >= midToy;
    }

    public static boolean numCheck(int number) {
        int squareSum = 0;
        int givenNumber = Math.abs(number);
        while (givenNumber > 0) {
            int digit = givenNumber % 10;
            squareSum += digit * digit;
            givenNumber /= 10;
        }
        return ((number % 2) == (squareSum % 2));
    }

    public static int countRoots(int[] coefficients) {
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];
        float x1 = 0;
        float x2 = 0;
        int discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return 0;
        } else if (discriminant == 0) {
            return 1;
        } else {
            int sqrtDiscriminant = (int) Math.sqrt(discriminant);
            if (sqrtDiscriminant * sqrtDiscriminant == discriminant) {
                x1 = (float)(- b + sqrtDiscriminant) /  (2 * a);
                x2 = (float)(- b - sqrtDiscriminant) / (2 * a);
                if ((x1 % 1 == 0) && (x2 % 1 == 0)) {
                    return 2;
                } else if ((x1 % 1 == 0) || (x2 % 1 == 0)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    public static List<String> salesData(String[][] salesData) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < salesData.length; i++) {
            String product = salesData[i][0];
            for (int j = 1; j < salesData[i].length; j++) {
                String shop = salesData[i][j];
                map.computeIfAbsent(shop, k -> new HashSet<>()).add(product);
            }
        }
        Set<String> commonProducts = new HashSet<>(map.values().iterator().next());
        for (Set<String> products : map.values()) {
            commonProducts.retainAll(products);
        }
        return new ArrayList<>(commonProducts);
    }

    public static boolean validSplit(String sentence) {
        String[] words = sentence.split("");
        int len = words.length;
        List letterFirst = new ArrayList();
        List letterLast = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            letterFirst.add(currentWord.charAt(0));
            letterLast.add(currentWord.charAt(currentWord.length() - 1));
        }
        letterFirst.retainAll(letterLast);
        if (((len - 1) == letterFirst.size()) || ((len) == letterFirst.size())) {
            return true;
        }
        return false;
    }

    public static boolean waveForm(int[] arr) {
        if (arr.length <= 1) {
            return true;}
        int count = 1;
        boolean flag = true; //больше
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;}
            if (flag) {
                if (arr[i - 1] > arr[i]) {
                    flag = false;
                    count += 1;}
            } else {
                if (arr[i - 1] < arr[i]) {
                    flag = true;
                    count += 1;}
            }}
        if (count == arr.length)
            return true;
        return false;
    }

    public static char commonVovel(String sentence) {
        sentence = sentence.toLowerCase();
        Map<Character, Integer> vowelsCount = new HashMap<>();
        String vowels = "yaeiou";
        for (char ch : sentence.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                vowelsCount.put(ch, vowelsCount.getOrDefault(ch, 0) + 1);
            }
        }
        char mostVowel = 'p';
        int max = 0;
        for (Map.Entry<Character, Integer> entry : vowelsCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostVowel = entry.getKey();
            }
        }
        return mostVowel;
    }

    public static String dataScience(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int sum = 0;
            for (int j = 0; j < arrays.length; j++) {
                sum += arrays[j][i];
            }
            arrays[i][i] = Math.round((sum - arrays[i][i]) / (float) (arrays.length - 1));
        }
        return Arrays.deepToString(arrays);
    }
}