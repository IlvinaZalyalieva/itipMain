import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("1-----------");
        Boolean result1 = sameLetterPattern("ABCBA", "BCDCB");
        System.out.println(result1);
        System.out.println("2-----------");
        System.out.println(spiderVsFly("B4", "G3"));
        System.out.println(spiderVsFly("A4", "G4"));
        System.out.println(spiderVsFly("F2", "B1"));
        System.out.println(spiderVsFly("C4", "A3"));
        System.out.println(spiderVsFly("H4", "A3"));
        System.out.println("3-----------");
        System.out.println(digitsCount(1289396387328L));
        System.out.println("4-----------");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println("5-----------");
        System.out.println("5-----------");
        int[] result5 = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(Arrays.deepToString(sumsUp(result5)));
        System.out.println("6-----------");
        String[] result6 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] res6 = {"10%"};
        System.out.println(takeDownAverage(result6));
        System.out.println("7-----------");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println("8-----------");
        System.out.println(setSetup(5, 3));
        System.out.println("9-----------");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); //новый год
        System.out.println(timeDifference("London", "February 29, 2000 23:40", "Rome")); //новый високосный месяц
        System.out.println(timeDifference("Moscow", "February 28, 2000 23:40", "Tehran")); //старый високосный месяц февраль
        System.out.println("10----------");
        System.out.println(isNew(321));
        System.out.println(isNew(130));
    }

    public static boolean sameLetterPattern(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char one = s1.charAt(i);
            char two = s2.charAt(i);
            if (map.containsKey(one)) {
                if (map.get(one) != two) {
                    return false;
                }
            } else {
                map.put(one, two);
            }
        }
        return (s1.length() == s2.length());
    }

    public static String spiderVsFly(String spider, String fly) {
        int[] spiderCoords = new int[2];
        spiderCoords[0] = spider.charAt(0) - 'A';
        spiderCoords[1] = spider.charAt(1) - '0'; // кольца

        int[] flyCoords = new int[2];
        flyCoords[0] = fly.charAt(0) - 'A';
        flyCoords[1] = fly.charAt(1) - '0';

        int e = 0;
        int ee = 0;
        int k;
        int kk = -1;

        if (Math.abs(spiderCoords[0] - flyCoords[0]) == 4) {
            StringBuilder result = new StringBuilder();
            for (int i = spiderCoords[1]; i > 0; i--) {
                result.append((char) ('A' + spiderCoords[0]));
                result.append((char) ('0' + i));
                result.append("-");
            }
            result.append("A0-");
            for (int i = 1; i < flyCoords[1]; i++) {
                result.append((char) ('A' + flyCoords[0]));
                result.append((char) ('0' + i));
                result.append("-");
            }
            result.append(fly);
            return result.toString();
        } else {
            StringBuilder result = new StringBuilder();
            for (; spiderCoords[1] > flyCoords[1]; spiderCoords[1]--) {
                result.append((char) ('A' + spiderCoords[0]));
                result.append((char) ('0' + spiderCoords[1]));
                result.append("-");
            }
            for (; spiderCoords[1] >= 0; spiderCoords[1]--) {
                if (spiderCoords[1] == 0) {
                    result.append("A0-");
                    spiderCoords[1] = 1;
                    break;
                }
                k = spiderCoords[0];
                if ((Math.abs(spiderCoords[0] - flyCoords[0]) < 3) || (Math.abs(spiderCoords[0] - flyCoords[0]) > 5)) {
                    if (Math.abs(spiderCoords[0] - flyCoords[0]) < 4) {
                        for (int j = spiderCoords[0]; j != flyCoords[0]; j += (int) Math.signum(flyCoords[0] - spiderCoords[0])) {
                            result.append((char) ('A' + j));
                            result.append((char) ('0' + spiderCoords[1]));
                            result.append("-");
                        }
                        break;
                    } else if (spiderCoords[0] < flyCoords[0]) {
                        for (int j = spiderCoords[0]; k != (flyCoords[0]); j--) {
                            if (j < 0) {
                                result.append((char) ('A' + (8 + e)));
                                result.append((char) ('0' + spiderCoords[1]));
                                result.append("-");
                            }
                            if (j >= 0) {
                                result.append((char) ('A' + j));
                                result.append((char) ('0' + spiderCoords[1]));
                                result.append("-");
                            }
                            e -= 1;
                            k = 8 + e;
                        }
                        break;
                    } else if (spiderCoords[0] > flyCoords[0]) {
                        for (int j = spiderCoords[0]; k != (flyCoords[0]); j++) {
                            if (j > 7) {
                                result.append((char) ('A' + (e)));
                                result.append((char) ('0' + spiderCoords[1]));
                                result.append("-");
                                e += 1;
                            }
                            if (j <= 7) {
                                result.append((char) ('A' + j));
                                result.append((char) ('0' + spiderCoords[1]));
                                result.append("-");
                            }
                            k += 1;
                            if (k == 8) {
                                k = 0;
                            }

                        }
                        break;
                    }
                }
                result.append((char) ('A' + spiderCoords[0]));
                result.append((char) ('0' + spiderCoords[1]));
                result.append("-");
            }
            for (int i = spiderCoords[1]; i < flyCoords[1]; i++) {
                result.append((char) ('A' + flyCoords[0]));
                result.append((char) ('0' + i));
                result.append("-");
            }
            result.append(fly);
            return result.toString();
        }
    }

    public static int digitsCount(long n) {
        if (n / 10 == 0) {
            return 1;
        }
        return digitsCount(n / 10) + 1;
    }

    private static String sortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static int totalPoints(String[] words, String mainWord) {
        char[] chars = mainWord.toCharArray();
        Arrays.sort(chars);
        mainWord = String.valueOf(chars);
        int score = 0;
        for (String word : words) {
            int thisScore = 0;
            word = sortedString(word);
            int i = 0;
            for (char letter : mainWord.toCharArray()) {
                if (letter == word.charAt(i)) {
                    thisScore++;
                    i++;
                }
            }
            if (i == word.length()) {
                score += thisScore - 2;
                if (mainWord.length() == word.length()) {
                    score += 50;
                }
            }
        }
        return score;
    }

    // !!!!!!
    public static int[][] sumsUp(int[] arr) {
        ArrayList<int[]> results = new ArrayList<>();
        int n = arr.length;
        int[][] coef = new int[n * n][n * n];
        for (int k = 2; k <= n; k++) {
            int[] workingArray = Arrays.copyOf(arr, k);
            for (int i = 0; i < workingArray.length - 1; i++) {
                for (int j = i + 1; j < workingArray.length; j++) {
                    if (coef[i][j] == 0) {
                        coef[i][j] = 2;
                        int a = workingArray[i];
                        int b = workingArray[j];
                        if (a + b == 8) {
                            int[] ab = {Math.min(a, b), Math.max(a, b)};
                            //if (coef[i][j] != 1) {
                            results.add(ab);
                            //}
                            //coef[i][j] = 1;
                        }
                    }
                }
            }
        }
        int[][] final_arr = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            final_arr[i] = results.get(i);
        }
        return final_arr;
    }

    public static String takeDownAverage(String[] list) {
        double sum = 0;
        for (String item : list) {
            sum += Integer.parseInt(item.substring(0, item.length() - 1));
        }
        double avg = (sum / list.length);
        double avg2 = avg - 5.0;
        double sum2 = avg2 * (list.length + 1);
        return Math.round(sum2 - sum) + "%";
    }

    public static String caesarCipher(String status, String text, int pos) {
        pos *= status.equals("encode") ? 1 : -1;
        StringBuilder result = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                result.append((char) ('A' + Math.floorMod(c - 'A' + pos, 26)));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static long setSetup(long n, long k) {
        if (k == 1) {
            return n;
        }
        return (n - k + 1) * setSetup(n, k - 1);
    }

    public static String timeDifference(String cityA, String stringDate, String cityB) {
        HashMap<String, TimeZone> timeZones = new HashMap<>();
        timeZones.put("Los Angeles", SimpleTimeZone.getTimeZone("GMT-8"));
        timeZones.put("New York", SimpleTimeZone.getTimeZone("GMT-5"));
        timeZones.put("Caracas", SimpleTimeZone.getTimeZone("GMT-4:30"));
        timeZones.put("Buenos Aires", SimpleTimeZone.getTimeZone("GMT-3"));
        timeZones.put("London", SimpleTimeZone.getTimeZone("GMT"));
        timeZones.put("Rome", SimpleTimeZone.getTimeZone("GMT+1"));
        timeZones.put("Moscow", SimpleTimeZone.getTimeZone("GMT+3"));
        timeZones.put("Tehran", SimpleTimeZone.getTimeZone("GMT+3:30"));
        timeZones.put("New Delhi", SimpleTimeZone.getTimeZone("GMT+5:30"));
        timeZones.put("Beijing", SimpleTimeZone.getTimeZone("GMT+8"));
        timeZones.put("Canberra", SimpleTimeZone.getTimeZone("GMT+10"));
        SimpleDateFormat firstFormat = new SimpleDateFormat("MMMM d, yyyy H:m", Locale.US);
        firstFormat.setTimeZone(timeZones.get(cityA));
        SimpleDateFormat secondFormat = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);
        secondFormat.setTimeZone(timeZones.get(cityB));
        try {
            return secondFormat.format(firstFormat.parse(stringDate));
        } catch (ParseException ignored) {
            return ignored.getMessage();
        }
    }

    public static boolean isNew(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        int number = n;
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.sort(digits);
        number = 0;
        int i = 0;
        while (!digits.isEmpty()) {
            number = number * 10 + digits.remove(i);
        }
        return number == n;
    }

}


