package org.wordgames;

import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;


class Permutation {
    static private Logger log = LogManager.getLogger(Permutation.class);
  static void getAllPossibleValues(String inputString, long targetLength){

       int length = inputString.length();

       Set<Integer> indexes = range(0, length).boxed().collect(toSet());
      ArrayList<String> allValues = new ArrayList<>();
      Set<String> uniqueValues = new HashSet<>();
      int bound = length + 1;
      for (int i = 1; i < bound; i++) {
          for (Set<Integer> indicesSet : Sets.combinations(indexes, i)) {
              StringBuilder sb = new StringBuilder();
              for (Integer integer : indicesSet) {
                  Character charAt = inputString.charAt(integer);
                  String valueOf = String.valueOf(charAt);
                  sb.append(valueOf);
              }
              String str = sb.toString();
              for (String s : GFG.GFGgetResult(str, targetLength)) {
                  if (uniqueValues.add(s)) {
                      allValues.add(s);
                  }
              }
          }
      }

      log.info("All combinations are founded ("+ allValues.size()+")");

      new File("all_permutations.csv");
      try (PrintWriter csvWriter = new PrintWriter(new FileWriter("all_permutations.csv"))) {
          for (String item:allValues){
                  csvWriter.println(item);
          }

      } catch (IOException e) {
          e.printStackTrace();
      }
      log.info("All combinations are inserted into file");
   }
}
