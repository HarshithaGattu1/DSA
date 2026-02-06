class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==1) return 0;
        int n=nums.length;
        int[] sumLeft = new int[n];//prefix array
        sumLeft[0] = nums[0];
        for(int i=1;i<n;i++) {
            sumLeft[i] = sumLeft[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--) {//taking nums array itself as suffix array 
            nums[i] +=nums[i+1];
        }
        for(int i=0;i<n;i++) {
            if(i==0 && nums[i+1] == 0) return i;
            if(i==n-1 && sumLeft[i-1] == 0) return i;
            if(i>0 && i+1 < n && sumLeft[i-1] == nums[i+1]) return i;
        }
        return -1;
    }
}