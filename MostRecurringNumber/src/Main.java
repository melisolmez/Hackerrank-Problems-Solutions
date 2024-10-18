import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int [] arr= {1,1,2,3,3,4,5,3,6};
        System.out.println( mostRecurringNumber(arr));
        System.out.println( mostRecurringNumber1(arr));

    }
    // zaman karmaşıklığı O(n)
    public static int mostRecurringNumber1(int[] n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int mostRecurringNumber = 0;
        int maxCount = 0;

        for (int num : n) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, count);

            if (count > maxCount) {
                maxCount = count;
                mostRecurringNumber = num;
            }
        }

        return mostRecurringNumber;
    }
    // zaman karmaşıklığı O(n^2)
    public static int mostRecurringNumber(int[] n) {
        int size = n.length;
        int mostRecurringNumber = 0;
        int count = 1;
        int numberOfRepetitions = 0;

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(n[i] == n[j]){
                    count++;
                }
            }

            if(count > numberOfRepetitions){
                numberOfRepetitions = count;
                mostRecurringNumber = n[i];
            }
            count=0;

        }

        return mostRecurringNumber;
    }
}