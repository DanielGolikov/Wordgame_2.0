import java.util.ArrayList;

class Heaps_algorithm {
    private Converter converter=new Converter();

    ArrayList<String> getChars() {
        return chars;
    }

    private ArrayList<String> chars=new ArrayList<>();


    void permutationHelper(char[] charArray, int currentPosition) {

        if (currentPosition == 1) {
            chars.add(converter.CharArrayToString(charArray));
        } else {
            for (int i = 0; i < currentPosition; i++) {
                int nextPosition = currentPosition - 1;
                permutationHelper(charArray, nextPosition);
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
