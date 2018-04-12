// 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。

// i 注意事项
// 数组中只有唯一的主元素

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        int result = -1;
        if (k <= 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        int n = nums.size();
        int compare = n / k;  
    
        /**
         * 以key作为数组里的数
         * 以value作为该值在数组上出现的次数
         */
        for (int i = 0; i < n; i++) {
            if ( !map.containsKey(nums.get(i)) ) {
                map.put(nums.get(i), 1);
            } else {
                map.put(nums.get(i), map.get(nums.get(i)) + 1);
            }
        }
        
        // 注意不是Entry，而是Map.Entry类型，因为Entry是Map的内部类
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            if (e.getValue() > compare) {
                result = e.getKey();
                break;
            }
        }
        
        return result;
    }
}

