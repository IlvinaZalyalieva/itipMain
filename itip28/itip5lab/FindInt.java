import java.util.regex.*;

public class FindInt {
    public static void main(String[] args) {
        String text = "The price of the -2 -3.7 product is $19.99";
        try {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

