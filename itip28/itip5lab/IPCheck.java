import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPCheck {
    public static void main(String[] args) {
        String ip = "12.294.34.08";
        try {
            Pattern pattern = Pattern.compile("((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).)" +
                    "{3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println("success");}
            else System.out.println("not success");}

        catch (Exception e) {
            System.out.println(e.getMessage());
        }}
}
