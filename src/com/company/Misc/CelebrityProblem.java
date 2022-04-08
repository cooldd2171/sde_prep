package com.company.Misc;

import java.util.Stack;

public class CelebrityProblem {
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
