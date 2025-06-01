// Leetcode Problem 746: Min Cost Climbing Stairs
import java.util.*;

public class Sol746 {
    public static void main(String[] args){
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost)); // Output: 15
    }

    public static int minCostClimbingStairs(int[] cost){
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    // recursive solution
    public static int dfs(int[] cost, int i){
        if (i>=cost.length) return 0;
        return cost[i] + Math.min(dfs(cost, i+1), dfs(cost, i+2));
    }
}