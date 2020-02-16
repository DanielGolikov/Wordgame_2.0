package org.wordgames;

import java.util.ArrayList;
import java.util.Set;

import static com.google.common.collect.Sets.combinations;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;
import static org.wordgames.HeapsAlgorithm.heapsAlgorithmGetAllValues;

 class Permutation {
   static ArrayList<String> getAllPossibleValues(String inputString){
        int length = inputString.length();

        Set<Integer> indexes = range(0, length).boxed().collect(toSet());
        Set<String> collect = range(1, length + 1)
                .boxed()
                .flatMap(numberOfCharInComb -> combinations(indexes, numberOfCharInComb).stream())
                .map(indicesSet ->
                        indicesSet.stream()
                                .map(inputString::charAt)
                                .map(String::valueOf)
                                .collect(joining()))
                .flatMap(str -> heapsAlgorithmGetAllValues(str).stream())
                .collect(toSet());
        ArrayList<String> result = new ArrayList<>(collect);
        return result;
    }
}
