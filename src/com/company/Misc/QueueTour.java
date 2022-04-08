package com.company.Misc;

public class QueueTour {
    
    public static void main(String[] args){
        int[] petrol={87, 27, 40, 95, 71, 96, 79, 35, 2, 68, 3, 98};
        int[] distance={ 93, 18, 57, 53, 81, 2, 42, 87, 90, 66, 20, 45, 30, 41};
        tour(petrol,distance);
    }

    static int tour(int petrol[], int distance[])
    {
        int index=-1;
        int positive=0;
        int negative=0;
        int currentAnswer=0;

        for(int i=0;i<petrol.length;i++){
            currentAnswer=positive+petrol[i]-distance[i];
            if(currentAnswer>=0){
                if(index==-1)index=i;
                positive+=petrol[i]-distance[i];
            }
            if(currentAnswer<0){
                negative=currentAnswer+negative;
                positive=0;
                index=-1;
            }
        }
        if(positive+negative<0){
            return -1;
        }
        return index;

    }
    
}
