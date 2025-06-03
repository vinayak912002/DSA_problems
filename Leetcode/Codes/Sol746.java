// Leetcode Problem 746: Min Cost Climbing Stairs
import java.util.*;

public class Sol746 {
    public static void main(String[] args){
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairsMemo(cost)); // Output: 15
    }

    // recursive solution
    public static int minCostClimbingStairs(int[] cost){
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public static int dfs(int[] cost, int i){
        if (i>=cost.length) return 0;
        return cost[i] + Math.min(dfs(cost, i+1), dfs(cost, i+2));
    }

    // memoization solution
    private static HashMap<Integer, Integer> memo;
    public static int minCostClimbingStairsMemo(int[] cost){
        memo = new HashMap<>();
        return Math.min(dfs(cost, 0), dfsMemo(cost, 1));
    }

    
    private static int dfsMemo(int[] cost, int i){
        if (i >=cost.length) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        
        int result = cost[i] + Math.min(dfsMemo(cost, i+1), dfsMemo(cost, i+2));
        memo.put(i, result);
        return result;
    }
}