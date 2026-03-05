class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j] == 1) {
                    if(find(i,j,mat)) count++;
                }
            }
        }
        return count;
    }
    boolean find(int i,int j,int[][] mat) {
        for(int col=0;col<mat[0].length;col++) {
            if(col == j) continue;
            if(mat[i][col] == 1) return false;
        }
        for(int row=0;row<mat.length;row++) {
            if(row == i) continue;
            if(mat[row][j] == 1) return false;
        }
        return true;
    }

}