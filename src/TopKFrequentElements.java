class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
            if(pq.size()>k) pq.poll();
        }
        int[] arr = new int[k];
        while(k!=0){
            arr[k-1] = pq.poll()[1];
            k--;
        }
        return arr;
    }
}

//less opt
// Time: O(n + m log m), where m is the number of distinct elements.


// Space: O(m).

// import java.util.*;

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         List<Integer> list = new ArrayList<>(map.keySet());

//         list.sort((a, b) -> map.get(b) - map.get(a));

//         int[] result = new int[k];

//         for (int i = 0; i < k; i++) {
//             result[i] = list.get(i);
//         }

//         return result;
//     }
// }