class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climing(0, n, memo);
    }
    private int climing(int i,int n, int memo[]) {
        //base case 1
        if (i > n) return 0;
        //base case 2
        if (i == n) return 1;
        //already stored this value
        if (memo[i] > 0) {
            return memo[i];
        }
        
        memo[i] = climing(i + 1, n, memo) + climing(i + 2, n , memo);
        return memo[i];
    }
}