class Solution {
    public boolean hasAlternatingBits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n>0) {
            int val = n&1;
            list.add(val);
            n = n>>1;
        }
        for(int i=0;i<list.size();i++) {
            if(i+1<list.size() && list.get(i) == list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}