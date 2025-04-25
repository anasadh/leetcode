class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

        long res = 0;

        int count = 0;

        for (int num : nums) {

            if (num % modulo== k) {
                count++;
            }

            int need = (count - k +modulo)% modulo;

            res += map.getOrDefault(need,0L);
            int modCount = count %modulo;
            map.put(modCount, map.getOrDefault(modCount, 0L) + 1);
        }

        return res;
    }
}