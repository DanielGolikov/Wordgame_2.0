import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;

public class Permutation {

    static ArrayList<String> getAllPossibleValues(String word) {

        Heaps_algorithm algorithm = new Heaps_algorithm();

        //Делаем из слова массив чаров
        char[] input = word.toCharArray();
        // Получаем все возможные значения для изначального количества символов
        ArrayList<String> chars = algorithm.getAllValues(input);
        //Убираем по одному символу с слова и каждый раз получаем все значения
        for (int i = 0; i < input.length; i++) {
            char[] charArray = ArrayUtils.removeAll(input, i);
            algorithm.getAllValues(charArray);
        }
        return chars;
    }
}
