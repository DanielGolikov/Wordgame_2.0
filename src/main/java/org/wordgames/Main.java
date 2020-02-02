package org.wordgames;
import java.io.IOException;
import java.util.*;
import static org.wordgames.Permutation.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       Set<String> output = getAllPossibleValues("attttttttt");
       System.out.println(output);
        System.out.println(output.size());

    }
}
