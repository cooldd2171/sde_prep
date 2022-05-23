package com.company.Misc;

public class AlgoExpertsAndSoftwareDevelopers {
    
    /*
    * There are N Algorithm Experts and N-1 Software Developers. You as Project
manager will exclude an Algorithm Expert and form N-1 teams each consist of a
software developer and an algorithm expert such that the efficiency of the whole
project is maximised, but the problem is you can't jumble the ordering as
the employees won't be happy.
There is an array algoExperts[] which denotes the skill of i algorithm expert and
an array Developers[] which denotes the skill of i software developer.
Efficency of a team is given by the product of the skill of software developer and the
algorithm expert, and total efficiency is the sum of the efficiencies of N-1 teams.
Input:
First line will contain an integer T denoting the number of testcases. First line of
each testcase contains a single integer N, denoting the size of the array. Next line
conatains N space separated integers denoting the skill of the Algorithm Experts
and last line of each teastcases contains N-1 elements denoting the skills of N-1
Software Developers.
Output:
Print the maximum total efficiency of the team formed.
Your Task:
You don't need to take input. Complete the function project() which takes
algoExperts[], Developers[] and size n as input and return the maximum efficiency
of the formed team. Printing is done by the driver code only.
Constraints:
1<=T<=30
2<=N<=10
0<=algoExperts[i]<=10
0<=Developers[i]<=10
Example:
Input:
2
5
4 1 5 2 9
1 2 1 1
answer: 25
* 
    * */
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
