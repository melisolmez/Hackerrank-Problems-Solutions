package com.melis;

import java.util.ArrayList;
import java.util.List;

/*
    This solution is for this problem ->  https://www.hackerrank.com/challenges/kindergarten-adventures/problem
 */

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(solve1(list));

    }

    // zaman karmaşıklığı O(n)
    public static int solve1(List<Integer> t) {
        int n = t.size();
        int[] runningSumBuilder = new int[n];

        for (int i = 0; i < n; i++) {
            if (t.get(i) == 0 || t.get(i) == n) {
                continue;
            }
            int indexToStartCounting = sanitizeIndex(i - t.get(i) + 1, n);
            int indexToStopCounting = sanitizeIndex(i + 1, n);

            runningSumBuilder[indexToStartCounting] += 1;
            if (indexToStopCounting == indexToStartCounting) {
                runningSumBuilder[0] += 1;
            } else {
                runningSumBuilder[indexToStopCounting] -= 1;
            }
        }

        int minCounter = Integer.MAX_VALUE;
        int bestStartingI = -1;

        int runningSum = 0;
        for (int i = 0; i < runningSumBuilder.length; i++) {
            runningSum += runningSumBuilder[i];
            if (runningSum < minCounter) {
                minCounter = runningSum;
                bestStartingI = i;
            }
        }

        return bestStartingI + 1;
    }

    public static int sanitizeIndex(int index, int n) {
        if (index >= 0 && index < n) {
            return index;
        }
        return (index + n) % n;
    }

    // zaman karmaşıklığı O(n^2)
    public static int solve(List<Integer> t) {
        int n = t.size(); // size of list so: students
        int maxComplete = 0; // max complete drawing
        int bestStart = 1; // best start for collects drawing


        for (int start = 0; start < n; start++) {
            int completeCount = 0;

            for (int i = 0; i < n; i++) {
                int studentIndex = (start + i) % n;
                int timeLeft = i;

                if (timeLeft >= t.get(studentIndex)) {
                    completeCount++;
                }
            }

            if (completeCount > maxComplete) {
                maxComplete = completeCount;
                bestStart = start + 1;
            }
        }

        return bestStart;
    }
}