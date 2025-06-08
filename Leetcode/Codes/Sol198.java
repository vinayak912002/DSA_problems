import java.util.*;

public class Sol198 {
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));// output should be 4
    }

    // memoized solution
    private static Map<Integer, Integer> map;
    
    private static int rob(int[] nums){
        map = new HashMap<>();
        return dfsMemo(nums, 0);
    }
    private static int dfsMemo(int[] nums, int i){
        if(i>=nums.length) return 0;
        if(map.containsKey(i)) return map.get(i);

        // At every house we have two options
        // 1 -> Rob the current house
        // 2 -> Skip the current house and rob the next one
        int rob = nums[i]+dfsMemo(nums, i+2);
        int skip = dfsMemo(nums, i+1);

        int res = Math.max(skip, rob);
        map.put(i, res);
        return res;
    }
}
