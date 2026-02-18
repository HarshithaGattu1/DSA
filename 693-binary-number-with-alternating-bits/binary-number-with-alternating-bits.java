class Solution {
    public boolean hasAlternatingBits(int n) {
        //tc O(logn) | sc 0(logn)
        //Any operation that works on the binary representation of a number usually takes O(log n) time.
        // ArrayList<Integer> list = new ArrayList<>();
        // while(n>0) {
        //     int val = n&1;
        //     list.add(val);
        //     n = n>>1;
        // }
        // for(int i=0;i<list.size();i++) {
        //     if(i+1<list.size() && list.get(i) == list.get(i+1))  {           return false;
        //     }
        // }
        //  return true;
        
        //TC O(logn) | SC O(1)
        int prev = -1;
        while (n > 0) {
            int curr = n & 1;
            if (curr == prev) {
                return false;
            }
            prev = curr;
            n >>= 1;
        }
        return true;

    }
}
     