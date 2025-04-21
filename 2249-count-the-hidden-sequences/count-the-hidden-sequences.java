class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long[] prefix = new long[n];
        prefix[0] = differences[0];
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + differences[i];
        }

        long minPrefix = 0, maxPrefix = 0;
        for (long num : prefix) {
            minPrefix = Math.min(minPrefix, num);
            maxPrefix = Math.max(maxPrefix, num);
        }

        long low = Math.max((long) lower, lower - minPrefix);
        long high = Math.min((long) upper, upper - maxPrefix);

        if (high < low) return 0;
        return (int) (high - low + 1);
    }
}