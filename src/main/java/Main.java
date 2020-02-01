import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
       // OxfordDictionaryAccess oxfordDictionaryAccess = new OxfordDictionaryAccess();
//        String inputWord=scanner.nextLine();
//        OxfordWordsChecker wordsGenerator=new OxfordWordsChecker();
//        System.out.println(wordsGenerator.findAllPossibleWords(inputWord));

        ArrayList<String> array=Permutation.getAllPossibleValues("tar");
        System.out.println(array + "   " + array.size());

    }
}
