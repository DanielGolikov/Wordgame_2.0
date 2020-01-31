import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class WordsGenerator {
     static Scanner scanner = new Scanner(System.in);
     static Converter converter = new Converter();

    public static void main(String[] args) {
        String input = scanner.nextLine();
        char[] arrayInput=converter.StringToCharArray(input);
        Heaps_algorithm algorithm= new Heaps_algorithm();
        algorithm.permutationHelper(arrayInput,arrayInput.length);
        System.out.println(algorithm.getChars());

    }


}
