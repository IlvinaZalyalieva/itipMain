import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("1-----------");
        String result1 = nonRepeatable("paparazzi");
        System.out.println(result1);
        System.out.println("2-----------");
        List<String> result2 = generateBrackets(3);
        System.out.println(result2);
        System.out.println("3-----------");
        List<String> result3 = binarySystem(4);
        System.out.println(result3);
        System.out.println("4-----------");
        String result4 = alphabeticRow("klmabzyxw");
        System.out.println(result4);
        System.out.println("5-----------");
        String result5 = count("aaabbcdd");
        System.out.println(result5);
        System.out.println("6-----------");
        System.out.println(convertToNum("one thousand five hundred sixty seven"));
        System.out.println("7-----------");
        System.out.println(uniqueSubstring("111111"));
        System.out.println("8-----------");
        int [][] res8 = {{2, 7, 3},{1, 4, 8},{4, 5, 9}};
        System.out.println(shortestWay(res8));
        System.out.println("9-----------");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println("10----------");
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.substring(0, str.length()-1).contains(String.valueOf(str.charAt(str.length()-1)))) {
            return nonRepeatable(str.substring(0, str.length()-1));
        } else {
            return nonRepeatable(str.substring(0, (str.length()-1))) + str.charAt(str.length()-1);
        }
    }
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String a : generateBrackets(i)) {
                    for (String b : generateBrackets(n - i - 1)) {
                        result.add(a + "(" +b + ")");
                    }
                }
            }
        }
        return result;
    }
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else if (n == 1) {
            result.add("0");
            result.add("1");
        } else {
            List<String> prev = binarySystem(n - 1);
            for (String s : prev) {
                if (!s.endsWith("0")) {
                    result.add(s + "0");
                }
                result.add(s + "1");
            }
        }
        return result;
    }

    public static String alphabeticRow(String s) {
        if (s.length() == 0)
            return "";
        String currentRow = "" + s.charAt(0);
        String maxRow = "" + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1 || s.charAt(i) == s.charAt(i - 1) - 1) {
                currentRow += s.charAt(i);
                if (currentRow.length() > maxRow.length()) {
                    maxRow = currentRow;
                }
            } else {
                currentRow = "" + s.charAt(i);
            }
        }
        return maxRow;
    }

    public static String count(String s) {
        if (s.length() == 0)
            return "";
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char symb = s.charAt(i);
            counts.put(symb, counts.getOrDefault(symb, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> sentence = new ArrayList<>(counts.entrySet());
        sentence.sort(Map.Entry.comparingByValue());
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> word : sentence) {
            res.append(word.getKey());
            res.append(word.getValue());
        }
        return res.toString();
    }

    public static int convertToNum(String str) {
        HashMap<String, Integer> numberWords = new HashMap<>();
        numberWords.put("zero", 0);
        numberWords.put("one", 1);
        numberWords.put("two", 2);
        numberWords.put("three", 3);
        numberWords.put("four", 4);
        numberWords.put("five", 5);
        numberWords.put("six", 6);
        numberWords.put("seven", 7);
        numberWords.put("eight", 8);
        numberWords.put("nine", 9);
        numberWords.put("ten", 10);
        numberWords.put("eleven", 11);
        numberWords.put("twelve", 12);
        numberWords.put("thirteen", 13);
        numberWords.put("fourteen", 14);
        numberWords.put("fifteen", 15);
        numberWords.put("sixteen", 16);
        numberWords.put("seventeen", 17);
        numberWords.put("eighteen", 18);
        numberWords.put("nineteen", 19);
        numberWords.put("twenty", 20);
        numberWords.put("thirty", 30);
        numberWords.put("forty", 40);
        numberWords.put("fifty", 50);
        numberWords.put("sixty", 60);
        numberWords.put("seventy", 70);
        numberWords.put("eighty", 80);
        numberWords.put("ninety", 90);

        String[] words = str.split(" ");

        int result = 0;
        int cur = 0;
        for (String word : words) {
            if (numberWords.containsKey(word)) {
                cur += numberWords.get(word);
            } else if (word.equals("hundred")) {
                cur *= 100;
            } else if (word.equals("thousand")) {
                result += cur * 1000;
                cur = 0;
            }
        }
        result += cur;
        return result;
    }

    public static String uniqueSubstring(String s) {
        if (s.length() == 0)
            return "";
        String maxS = "";
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index >= start) {
                    start = index + 1;
                }
            }
            map.put(c, end);
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxS = s.substring(start, end + 1);
            }
        }
        return maxS;
    }

    public static int shortestWay(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = n;
        int[][] shortMat = new int[m][n];
        shortMat[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            shortMat[i][0] = shortMat[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            shortMat[0][j] = shortMat[0][j-1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                shortMat[i][j] = Math.min(shortMat[i-1][j], shortMat[i][j-1]) + matrix[i][j];
            }
        }
        return shortMat[m-1][n-1];
    }

    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        HashMap<Integer, String> wordMap = new HashMap<>();
        for (String word : words) {
            String wordNotNum = word.replaceAll("[^a-zA-Z]", "");
            String numberStr = word.replaceAll("[^0-9]", "");

            if (!numberStr.isEmpty() && wordNotNum.length() > 0) {
                int pos = Integer.parseInt(numberStr);
                wordMap.put(pos, wordNotNum);
            }
        }
        ArrayList<String> sent = new ArrayList<>();
        for (int i = 1; i <= wordMap.size(); i++) {
            sent.add(wordMap.get(i));
        }
        String result = String.join(" ", sent);
        return result;
    }

    public static int switchNums(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        int[] position = new int[10];
        for (char one : str1.toCharArray()) {
            position[Character.getNumericValue(one)] += 1;
        }
        char[] numNew = str2.toCharArray();
        for (int i = 0; i < numNew.length; i++) {
            char currentDigit = numNew[i];
            for (int j = 9; j > -1; j--) {
                if (position[j] > 0 && j > Character.getNumericValue(currentDigit)) {
                    numNew[i] = (char) ('0' + j);
                    position[j] -= 1;
                    break;
                }
            }
        }
        String result10 = new String(numNew);
        return Integer.parseInt(result10);
    }
}
