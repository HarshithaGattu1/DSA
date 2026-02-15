class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<bulbs.size();i++) {
            if(!(list.contains(bulbs.get(i)))) {
                list.add(bulbs.get(i));
            }
            else {
                list.remove(bulbs.get(i));
            }
        }
        Collections.sort(list);
        return list;
    }
}