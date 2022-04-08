package com.company.Misc;

public class AlgoExpertsAndSoftwareDevelopers {
    
    public static void main(String[] args){
        
        long a[]={4,1,5,2,9};
        long b[]={1,2,1,1};
        project(a,b,5);
    }

    static long project(long algoExperts[], long Developers[], int n)
    {
        // Code here
        long answer=0;

        long preSum[]=new long[n];
        long postSum[]=new long[n];
        
        preSum[0]=algoExperts[0]*Developers[0];
        for(int i=1;i<n-1;i++){
            preSum[i]=preSum[i-1]+algoExperts[i]*Developers[i];
        }
        postSum[n-2]=algoExperts[n-1]*Developers[n-2];
        for(int i=n-3;i>=0;i--){
            postSum[i]=postSum[i+1]+
                    algoExperts[i+1]*Developers[i];
        }
        for(int i=1;i<n-1;i++){
            answer=Math.max(answer,preSum[i-1]+postSum[i]);
        }
        return Math.max(answer,Math.max(preSum[n-2],postSum[0]));

    }
    
}
