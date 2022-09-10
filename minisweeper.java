// TC:O(m*n)
// SC:O(m*n)

class Solution {
    int [][] dirs;
    int m;
    int n;
    public char[][] updateBoard(char[][] board, int[] click) {
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        m=board.length;
        n=board[0].length;
        Queue<int[]> q = new LinkedList<>();
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        q.add(new int[]{click[0],click[1]});
        board[click[0]][click[1]]='B';
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int count=getCount(board,curr[0],curr[1]);
            if(count>0){
                board[curr[0]][curr[1]]=(char)(count+'0');
            }else{
                for(int[] dir: dirs){
                    int i=curr[0] + dir[0];
                    int j=curr[1] + dir[1];
                    if(i>=0 && i<m && j>=0 && j<n && board[i][j]=='E'){
                        board[i][j]='B';
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        
        return board;
    }
    private int getCount(char[][] board,int i,int j){
        int count=0;
        for(int[] dir:dirs){
            int ii=dir[0]+i;
            int jj=dir[1]+j;
            if(ii>=0 && ii<m && jj>=0 && jj<n && board[ii][jj]=='M'){
                count++;
            }
        }
        return count;
    }
}
