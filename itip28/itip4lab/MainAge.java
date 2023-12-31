import java.io.*;


public class MainAge {
    public static void main(String[] args) {
        int age = 130;
        try {
            if (age < 0 || age > 120) {
                throw new CustomAgeException("Недопустимый возраст");
            }
            System.out.println("Возраст: " + age);
        } catch (CustomAgeException e) {
            logException(e);
            //System.out.println("Ошибка: " + e.getMessage());

        }
    }
    private static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("C:\\Users\\Lenovo\\Documents\\log.txt", true)) {
            writer.write("Exc" + e.getMessage() + "\n");
        } catch (IOException ioException) {
            System.out.println("Error записи в документ" + ioException.getMessage());
        }
    }}

