import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkEdit {
    public static void main(String[] args) {
        String text = "vhjvh go88ogle.ru ioi";
        try {
        Pattern pattern = Pattern.compile("[-A-Za-z0-9]*[.][com|ru]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String url = matcher.group();
            String url2 = "http://" + url;
            text = text.replace(url, url2);
        }
        System.out.println(text);}
        catch (Exception e) { System.out.println(e.getMessage());

    }
}}

