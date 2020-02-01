import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        OxfordDictionaryAccess oxfordDictionaryAccess = new OxfordDictionaryAccess();
        String inputWord=scanner.nextLine();
        WordsGenerator wordsGenerator=new WordsGenerator();
        System.out.println(wordsGenerator.findAllPossibleWords(inputWord));
        System.out.println(oxfordDictionaryAccess.getWordDescription("tar"));
    }
}
