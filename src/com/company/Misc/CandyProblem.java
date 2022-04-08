package com.company.Misc;

public class CandyProblem {
    
    public static void main(String[] args){
        int arr[]={1,2,87,87,87,2,1};
        candy(arr);
    }

    public static int candy(int[] ratings) {

        int answer=0;

        int arr[]=new int[ratings.length];

        for(int i=0;i<ratings.length;i++){
            arr[i]=1;
        }

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && arr[i]<=arr[i+1]){
                arr[i]=arr[i+1]+1;
            }
        }


        for(int i=0;i<ratings.length;i++){
            answer+=arr[i];
        }

        return answer;

    }
    
}
