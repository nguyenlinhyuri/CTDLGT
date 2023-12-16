import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> map = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            } else map.put(nums[i], map.get(nums[i]) + 1);
        }

        Queue <Map.Entry<Integer, Integer>> q = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(e -> e.getValue())));
        for (Map.Entry entry : map.entrySet()){
            q.add(entry);
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++){
            result[i] = q.poll().getKey();
        }
        return result;
    }
}