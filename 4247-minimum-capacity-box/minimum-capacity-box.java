class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minBoxInd = -1;
        for(int i=0;i<capacity.length;i++) {
            if(capacity[i] >= itemSize && minBoxInd==-1) {
                minBoxInd = i;
            }
            if(minBoxInd!=-1&&capacity[i] >= itemSize && capacity[i] < capacity[minBoxInd] ) {
                minBoxInd = i;
            }
        }
        return minBoxInd;
    }
}