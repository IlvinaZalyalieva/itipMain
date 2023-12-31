import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
    String password = "qqqQQQ11100000000";
    try {
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16})");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Успех");}
        else System.out.println("Не успех");}
    catch (Exception e) {
        System.out.println(e.getMessage());
    }

    }
}
