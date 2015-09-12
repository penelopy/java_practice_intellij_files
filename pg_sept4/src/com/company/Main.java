

public class pg_sept4 {

    public static void main(String[] args) {
	    String[] wordListOne = {
            "multi-Tier", "30,000 feet", "win-win"
            };
        String[] wordListTwo = {
                "empowered", "branded", "cooperative"
        };
        String[] wordListThree = {
                "solution", "portal", "mission"
        };
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        System.out.println("What we need is a " + phrase);
    }
}
