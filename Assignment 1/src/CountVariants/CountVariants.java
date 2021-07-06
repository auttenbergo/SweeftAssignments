package CountVariants;

public class CountVariants {


    /*
        Solution 1:
            Exceeds time on leetcode.com

        Recursive Fibonacci sequence
     */
    /*
    public static int countVariants(int stairsCount){
        if(stairsCount == 0)
            return 1;

        if(stairsCount < 0)
            return 0;

        int oneStepCount = countVariants(stairsCount - 1);
        int twoStepCount = countVariants(stairsCount - 2);

        return oneStepCount + twoStepCount;
    }
    */

    /*
        Solution 2:
            Dynamic Programming Fibonacci sequence
     */
    public static int countVariants(int stairsCount){
        if(stairsCount == 1)
            return 1;
        int dp[] = new int[stairsCount];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<stairsCount; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[stairsCount-1];
    }


    public static void main(String[] args) {
        int stairsCount = 4;
        System.out.println(countVariants(stairsCount));
    }
}
