class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //O(n)
       // O(n²) happens when: For every j, i starts again from 0
       //But in sliding window: i never resets so TC is O(n)
        int l=0,r=0,n=nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum=0;
        while(r<n) {
            sum += nums[r];
            while(sum >= target) {
                minLen = Math.min(minLen,r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return (minLen == Integer.MAX_VALUE)?0:minLen;

    }
}