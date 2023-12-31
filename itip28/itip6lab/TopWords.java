import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TopWords {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "C:\\Users\\Lenovo\\Documents\\input.txt";
        // создаем объект File
        File file = new File(filePath);
        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }// создаем объект Map для хранения слов и их количества
        Map<String, Integer> map = new HashMap<>();
        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty())
                if (map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);}
        // закрываем Scanner
        scanner.close();
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String,
                    Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // выводим топ-10 слов
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        count++;
        if (count == 10)
            break;}
    }
}

