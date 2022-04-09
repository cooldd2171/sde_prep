package com.company.Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxRectangleGrid {
    
    public static void main(String[] args) {
        int m[][]={ {0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0,1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1 ,0, 1, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1, 0 ,1, 1}};
        maxArea(m,5,12);
        System.out.println("hello");
    }

    public static int maxArea(int M[][], int n, int m) {
        // add code here.
        int answer=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]!=0)
                M[i][j]+=M[i-1][j];
            }
            answer=Math.max(answer,compute(M,i-1,m));
        }
        answer=Math.max(answer,compute(M,n-1,m));
        return answer;
    }

    public static int compute(int M[][],int i, int m){

        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int area=0;

        for(int j=1;j<m;j++){
            if(!stack.isEmpty()&&M[i][stack.peek()]>M[i][j]){
                int index=stack.pop();
                area=Math.max(area,M[i][index]);
                while(!stack.isEmpty()&&M[i][stack.peek()]>M[i][j]){
                    int current=stack.pop(); 
                    int newArea=(index-current+1)*M[i][current];
                    if(stack.isEmpty()){
                        newArea=index*M[i][current];
                    }
                    area=Math.max(area,newArea);
                }
            }
            stack.push(j);
        }
        List<Integer> list=new ArrayList<>(stack);
        for(int x=0;x<list.size();x++){
            area=Math.max(area,(list.get(list.size()-1)-list.get(x)+1)*M[i][list.get(x)]);
            if(x==0){
                area=Math.max(area,(list.get(list.size()-1)+1)*M[i][list.get(x)]);
            }
        }
        return area;

    }
}
