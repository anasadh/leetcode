class Solution {
    public int kSimilarity(String s1, String s2) {
        return getMin(0, s1.toCharArray(), s2, new HashMap<>());
    }

    public int getMin(int idx, char[] arr, String s2, Map<String, Integer> cache){
        if(idx == arr.length){
            return 0;
        }
        String k = new String(arr);
        if(cache.containsKey(k)){
            return cache.get(k);
        }
        if(arr[idx] == s2.charAt(idx)){
            return getMin(idx + 1, arr, s2, cache);
        } 

        int min = Integer.MAX_VALUE;
        for(int j = idx + 1; j < arr.length; j++){
            if(arr[j] != s2.charAt(j) && arr[j] == s2.charAt(idx)){
                swap(idx, j, arr);
                min = Math.min(min, 1 + getMin(idx + 1, arr, s2, cache));
                swap(idx, j, arr);
            }
        }
        cache.put(k, min);
        return min;
    }

    public void swap(int i, int j, char[] arr){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}