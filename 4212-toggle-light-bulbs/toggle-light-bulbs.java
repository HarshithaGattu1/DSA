class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        //O(n*n);
        // List<Integer> list = new ArrayList<>();
        // for(int i=0;i<bulbs.size();i++) {
        //     if(!(list.contains(bulbs.get(i)))) {
        //         list.add(bulbs.get(i));
        //     }
        //     else {
        //         list.remove(bulbs.get(i));
        //     }
        // }
        // Collections.sort(list);
        // return list;

        //O(n)
        boolean[] bulbStatus = new boolean[101];
        for(int bulb : bulbs) {
            bulbStatus[bulb] = !bulbStatus[bulb];
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<101;i++) {
            if(bulbStatus[i]) list.add(i);
        }
        return list;
    }
}