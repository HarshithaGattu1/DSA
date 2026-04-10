class Solution {
    public int minimumDistance(int[] nums) {
        if(nums.length < 3) {
            return -1;
        }
        HashMap<Integer,int[]> hm = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            int key = nums[i];
            if(!hm.containsKey(key)) {
                hm.put(key,new int[]{i,0,0});
            }
            else {
                int ind[] = hm.get(key);
                if(ind[1] == 0) ind[1] = i;
                else if(ind[2] == 0) {
                    ind[2] = i;
                    int ind1 = ind[0];
                    int ind2 = ind[1];
                    int ind3 = ind[2];
                    int dist = Math.abs(ind1-ind2)+Math.abs(ind2-ind3)+Math.abs(ind3-ind1);
                    minDist = (dist < minDist) ? dist : minDist;
                }
                else {
                    ind[0] = ind[1];
                    ind[1] = ind[2];
                    ind[2] = i;
                    int ind1 = ind[0];
                    int ind2 = ind[1];
                    int ind3 = ind[2];
                    int dist = Math.abs(ind1-ind2)+Math.abs(ind2-ind3)+Math.abs(ind3-ind1);
                    minDist = (dist < minDist) ? dist : minDist;
                }
            }
        }
        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }
}