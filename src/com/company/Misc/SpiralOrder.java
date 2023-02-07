package com.company.Misc;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        int matrix[][]={{2,3}};
        spiralOrder(matrix);
                
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        int left=0;
        int right=matrix[0].length;
        int top=0;
        int bottom=matrix.length;
        
        List<Integer> answer=new ArrayList<>();
        
        while (left<right && top<bottom){
            
            for(int i=left;i<right;i++){
                answer.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<bottom;i++){
                answer.add(matrix[i][right-1]);
            }
            right--;
            for(int i=right-1;i>left;i--){
                answer.add(matrix[bottom-1][i]);
            }
            bottom--;
            for(int i=bottom-1;i>top;i--){
                answer.add(matrix[i][left]);
            }
            left++;
        }
        
        return answer;
        
    }
}
