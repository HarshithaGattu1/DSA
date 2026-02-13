class Solution {
    public int dominantIndices(int[] nums) {
        float[] suff = new float[nums.length];
        int n = nums.length;
        suff[n-1] = nums[n-1];
        float sum=nums[n-1];
        for(int i=n-2;i>=0;i--) {
            sum += nums[i];
            suff[i] = sum/(n-i);
        }
        int count=0;
        for(int i=0;i<n-1;i++) {
            if(nums[i] > suff[i+1]) count++;
        }
        return count;
    }
}