import java.util.ArrayList;
import java.util.List;

/*
 - this solution is for this problem https://www.hackerrank.com/challenges/find-maximum-index-product
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(solve(arr));
    }
    public static int solve(List<Integer> arr) {
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.size(); i++) {
            int result = 0;

            // sag
            for (int j = i + 1; j < arr.size(); j++) {
                if (j > i) {
                    if (arr.get(j) > arr.get(i)) {
                        right = j;
                        right++;
                        break;
                    } else {
                        right = 0;
                    }
                }
            }

            // sol
            if (i > 0) {
                for (int k = i - 1; k < i; k++) {
                    if (arr.get(k) > arr.get(i)) {
                        left = k;
                        left++;
                        break;
                    } else {
                        left = 0;
                    }
                }
            }

            result = right * left;
            if (result > max) {
                max = result;
            }
        }
        return max;
    }
}