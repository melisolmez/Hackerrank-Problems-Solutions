import java.util.List;


public class Main {
    public static void main(String[] args) {


    }
    private static final int FIELD = 100000;
    public static int solve1(List<List<Integer>> shots, List<List<Integer>> players) {

        int[] opening = new int[FIELD];
        int[] closing = new int[FIELD];

        for (int i = 0; i < shots.size(); i++) {
            int a = shots.get(i).get(0);
            int b = shots.get(i).get(1);
            opening[a]++;
            closing[b + 1]++;
        }

        for (int i = 1; i < FIELD; i++) {
            opening[i] += opening[i - 1];
            closing[i] += closing[i - 1];
        }

        int overlapping = 0;


        for (int i = 0; i < players.size(); i++) {
            int a = players.get(i).get(0);
            int b =  players.get(i).get(1);
            overlapping += opening[b] - closing[a];
        }
        return overlapping;

    }

    public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
        // Write your code here
        int totalStrength = 0;

        for (int i = 0; i < players.size(); i++) {
            int playerStrength = 0;
            int playerStart = players.get(i).get(0);
            int playerEnd = players.get(i).get(1);

            for (int j = 0; j < shots.size(); j++) {
                int shotStart = shots.get(j).get(0);
                int shotEnd = shots.get(j).get(1);


                if (playerStart <= shotEnd && playerEnd >= shotStart) {
                    playerStrength++;
                }
            }

            totalStrength += playerStrength;
        }

        return totalStrength;

    }
}