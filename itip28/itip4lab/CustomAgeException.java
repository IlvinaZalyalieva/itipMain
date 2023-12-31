import java.io.FileWriter;
import java.io.IOException;

public class CustomAgeException extends Exception {
    public CustomAgeException(String message) {
        super(message);
    }
}