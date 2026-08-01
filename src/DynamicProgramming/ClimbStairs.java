package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    public static int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();

        return climbHelper(n, memo);
    }

    private static int climbHelper(int n, Map<Integer, Integer> memo) {
        if(n<=1) return 1;
        if(memo.containsKey(n)) return memo.get(n);
        memo.put(n,climbHelper(n-1,memo)+climbHelper(n-2,memo));
        return memo.get(n);
    }

    // using DP array
    public int stairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Fibonacci and Climb Stairs are essentially the **same problem!**
    //using only 2 variables, no need to maintain whole array
    public int stairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
