package com.company.DynamicProgramming;

import java.util.*;

public class CardsDistribution {
   
    public static void main(String[] args){
        int a[]={-1, 0, 1, 1, 2, -1, -4};
        answer=0;
        Stack<Integer> st =new Stack<>();
        ways2(a,0,0,1,new ArrayList<>());
        System.out.println(answer);
    }

    static int answer=0;
    static List<List<Integer>> answerList;
    static void ways2(int a[], int index, int sum,int count,List<Integer> list) {

        if(index>=a.length||count>a.length/2){
            return;
        }
        if(sum==0&&count==a.length/2){
            Collections.sort(list);
            for(List<Integer> each: answerList){
                if(each.equals(list)){
                    return;
                }
            }
            answerList.add(list);
            return;
        }
        List<Integer> t1=new ArrayList<>(list);
        t1.add(a[index]);
        ways2(a,index+1,sum+a[index],count+1,t1);
        ways2(a,index+1,sum,count,list);


    }

    public ArrayList<Integer> finalSeq(int cars[], int n) {

        Stack<Integer> st=new Stack<>();
        st.push(cars[0]);
        for(int i=1;i<n;i++){
            if(cars[i]>0){
                st.push(cars[i]);
                continue;
            }
            while(!st.isEmpty()){
                Integer top = st.peek();
                if(top<0){
                    st.push(cars[i]);
                    break;
                }
                else{//top>0 value<0
                    if(top<=Math.abs(cars[i])){
                        st.pop();
                    }else{
                        break;
                    }
                }
            }
            

        }


        ArrayList<Integer> answer=new ArrayList<>(st);
        return answer;
    }
}
