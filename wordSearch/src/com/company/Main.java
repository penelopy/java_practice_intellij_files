import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Grid g = new Grid(new char[][]
                {
                        {'d', 'b', 'c', 'd'}, //0
                        {'x', 'e', 'z', 'f'}, //1
                        {'d', 'e', 'f', 'a'}  //2
                });


//        g.getWordLocation(g, "db");

        Test.assertNull("location", g.getWordLocation("nonsense"));
        Test.assertTrue("location for 'db' should be non-null", g.getWordLocation("db") != null);

        Test.assertEquals("location", new Location(0,0,1,0), g.getWordLocation("db"));
        Test.assertEquals("location", new Location(0,0,0,1), g.getWordLocation("dx"));


        System.out.println("Done!");
    }
}

class Location {
    public final int x1, y1, x2, y2;

    public Location(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d : %d,%d)", x1, y1, x2, y2);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Location) {
            Location rhs = (Location) other;
            return x1 == rhs.x1 && x2 == rhs.x2 && y1 == rhs.y1 && y2 == rhs.y2;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class Grid {
    // fields
    static final int[] NOT_FOUND = { -1, -1 };
    private final char[][] letters;

    // constructor(s)
    public Grid(char[][] letters) {
        this.letters = letters;
    }

    /**
     * Returns the location of the given word, or null if not found. If
     * the word occurs multiple times, only one of those locations is
     * returned.
     */

    public int[] getWordLocation(String word) {
        char startChar = word.charAt(0);
        char endChar = word.charAt(word.length() - 1);

        int[] starCharCoords = getCharCoords(startChar);
        int[] endCharCoords = getCharCoords(endChar);
    }

    private int[] getCharCoords(char target) {
        System.out.println(this.letters);
        for (int i = 0; i < this.letters.length; i++) {
            for (int j = 0; j < this.letters[i].length; j++) {
                char c = this.letters[i][j];
                if (c == target) {
                    return new int[]{i, j};
                }
            }
        }
        return NOT_FOUND;

        }
}


class Test {
    public static void assertEquals(String message, int expected, int actual) {
        if (expected != actual) {
            String output = String.format("%s: expected %d but is %d%n",
                    message, expected, actual);
            throw new AssertionError(output);
        }
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        if (expected == actual) return;

        if ((expected == null || actual == null) || !expected.equals(actual)) {
            String output = String.format("%s: expected %s but is %s%n",
                    message, expected, actual);
            throw new AssertionError(output);
        }
    }


    public static void assertNull(String message, Object shouldBeNull) {
        if (shouldBeNull != null) {
            throw new AssertionError("Expected null: " + message);
        }
    }

    public static void assertTrue(String message, boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected true: " + message);
        }
    }
}

