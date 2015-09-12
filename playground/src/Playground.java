/**
 * Created by penelope on 9/3/15.
 */
public class Playground {

    static final int[] NOT_FOUND = { -1, -1 };

    public static void main(String[] args) {
        char[][] array = new char[][]
        {
                { 'd', 'b', 'c', 'd' }, //0
                { 'x', 'e', 'z', 'f' }, //1
                { 'd', 'e', 'f', 'a' }  //2
        };
        getWordLocation(array, "db");
    }

    private static void getWordLocation(char[][] array, String word) {
        char startChar = word.charAt(0);
        char endChar = word.charAt(word.length() - 1);

        int[] starCharCoords = getCharCoords(array, startChar);
        int[] endCharCoords = getCharCoords(array, endChar);
    }

    private static int[] getCharCoords(char[][] array, char target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                char c = array[i][j];
                if (c == target) {
                    return new int[]{i, j};
                }
            }
        }
        return NOT_FOUND;
    }
}
