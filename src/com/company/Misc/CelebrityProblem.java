package com.company.Misc;

import java.util.Stack;

public class CelebrityProblem {
    
    /*
    * 
    A celebrity is a person who is known to all but does not know anyone at a party.
    *  If you go to a party of N people, find if there is a celebrity in the party or not.
    A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j
    is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
    Note: Follow 0 based indexing.
     
    
    Example 1:
    
    Input:
    N = 3
    M[][] = {{0 1 0},
             {0 0 0}, 
             {0 1 0}}
    Output: 1
    Explanation: 0th and 2nd person both
    know 1. Therefore, 1 is the celebrity. 
    * */
    public static void main(String[] args) {
        
    }

    int celebrity(int M[][], int n)
    {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>1){
            int x=st.pop();
            int y=st.pop();
            if(M[x][y]==1){
                st.push(y);
            }
            else{
                st.push(x);
            }
        }
        if(st.isEmpty()){
            return -1;
        }
        int answer=st.pop();
        for(int i=0;i<n;i++){
            if(i!=answer && M[i][answer]!=1 || M[answer][i]!=0){
                return -1;
            }
        }
        return answer;
    }
}
