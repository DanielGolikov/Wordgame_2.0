import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        OxfordDictionaryAccess oxfordDictionaryAccess = new OxfordDictionaryAccess();
        List<String> result = (List<String>) oxfordDictionaryAccess.getWordDescription("home");
        if (!result.isEmpty())
        System.out.println(result);
    }
}
