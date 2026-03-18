class Solution {
    public String getHappyString(int n, int k) {
        if(n == 1 && k == 1) return "a"; 
        if(n == 1 && k == 2) return "b"; 
        if(n == 1 && k == 3) return "c"; 
        if(n == 1 && k > 3) return ""; 

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        add(sb,'a',list,n);
        if(list.size()  >= k) return list.get(k-1);
        add(sb,'b',list,n);
        if(list.size()  >= k) return list.get(k-1);
        add(sb,'c',list,n);
       String ans = (list.size() >= k ) ? list.get(k-1) : "";
       return ans;
    }
    public void add(StringBuilder sb,char val,ArrayList<String> list,int n) {
       if(sb.length()>=1 && sb.charAt(sb.length()-1) == val) {
            return;
        }

        sb.append(val);

        if(sb.length() == n){
            list.add(sb.toString());   
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        add(sb,'a',list,n);
        add(sb,'b',list,n);
        add(sb,'c',list,n);

        sb.deleteCharAt(sb.length()-1);
    }
}