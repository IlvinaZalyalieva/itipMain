import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindChar {
    public static void main(String[] args) {
        String c = "p";
        String text = "The app price p of the Product is $19.99";
        try {
            text = text.toLowerCase();
            Pattern pattern = Pattern.compile( "\\b"+ c  +"[a-z]*?\\b");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
           }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
