package org.wordgames;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class HeapsAlgorithm {

    public static Set<String> heapsAlgorithmGetAllValues(String string) {
        char[] charArray = string.toCharArray();
        List<String> chars = new ArrayList<>();
        return Sets.newHashSet(useHeapsAlgorithm(charArray, charArray.length, chars));
    }

    private static List<String> useHeapsAlgorithm(char[] charArray, int currentPosition, List<String> chars) {
        if (currentPosition == 1) {
            chars.add(new String(charArray));
        } else {
            for (int i = 0; i < currentPosition; i++) {
                int nextPosition = currentPosition - 1;
                useHeapsAlgorithm(charArray, nextPosition, chars);
                swap(charArray, currentPosition % 2 == 0 ? i : 0, nextPosition);
            }
        }
        return chars;
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}