
import java.util.ArrayList;

class Heaps_algorithm {

    private ArrayList<String> chars=new ArrayList<>();

     ArrayList<String> getAllValues(char[] charArray){
        useHeapsAlgorithm(charArray,charArray.length);
        return chars;
    }

     private void useHeapsAlgorithm(char[] charArray, int currentPosition) {

        if (currentPosition == 1) {
            chars.add(new String(charArray));
        } else {
            for (int i = 0; i < currentPosition; i++) {
                int nextPosition = currentPosition - 1;
                useHeapsAlgorithm(charArray, nextPosition);
                swap(charArray, currentPosition % 2 == 0 ? i : 0, nextPosition);
            }
        }
    }
    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}