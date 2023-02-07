package com.company.Graph;

public class WordSearch {

    public static void main(String[] args) {
        
        char[][] board={{'a', 'g' ,'b' ,'c'},
                {'q', 'e', 'e', 'l'},
                {'g', 'b', 'k', 's' }};
        isWordExist(board,"geeks");
        
    }

    public static boolean isWordExist(char[][] board, String word)
    {
        visited=new boolean[101][101];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }

        return false;
    }
    static boolean[][] visited;
    static boolean dfs(char[][] board,String word, int ptr,int i,int j){
        if(i>=board.length||j>=board[0].length||ptr==word.length()||i<0||j<0){
            return false;
        }
        if(visited[i][j]||word.charAt(ptr)!=board[i][j]){
            return false;
        }
        visited[i][j]=true;

        if(word.charAt(ptr)==board[i][j]&&ptr==word.length()-1){
            return true;
        }

        boolean x= dfs(board,word,ptr+1,i,j+1)||dfs(board,word,ptr+1,i,j-1)||
                dfs(board,word,ptr+1,i+1,j)||dfs(board,word,ptr+1,i-1,j);
        visited[i][j]=false;
        return x;
    }
}
