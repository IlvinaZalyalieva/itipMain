import java.io.*;

public class FileWrRe {
    public static void main(String[] args) {
        try {
            File input = new File("C:\\Users\\Lenovo\\Documents\\input.txt");
            FileReader in1 = new FileReader(input);
            File output = new File("C:\\Users\\Lenovo\\Documents\\output.txt");
            FileWriter out2 = new FileWriter(output);
            int charr;
            while ((charr = in1.read()) != -1) {
                System.out.println(charr);
                out2.write(charr);
            }
            in1.close();
            out2.close();
            out2.write("qwe");
            System.out.println("Файл записан");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


