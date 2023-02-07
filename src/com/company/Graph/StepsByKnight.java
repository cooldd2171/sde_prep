package com.company.Graph;

import java.util.*;

public class StepsByKnight {
    
    public static void main(String[] args){
        
    }

    static class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y,int distance) {
            this.x = x;
            this.y = y;
            this.distance=distance;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.x,this.y);
        }
        
    }
    
    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        int answer=0;
        Queue<Node> queue=new LinkedList<>();
        int destX=TargetPos[0];
        int destY=TargetPos[1];
        queue.add(new Node(KnightPos[0],KnightPos[1],0));
        Set<Node> visited=new HashSet<>();
        while (!queue.isEmpty()){
            Node first = queue.poll();
            if(first.x==destX&&first.y==destY){
                return first.distance;
            }
            if(visited.contains(first)){
                continue;
            }
            visited.add(new Node(first.x,first.y));
            int distance= first.distance+1;
            if(first.x-2>0&&first.y-1>0&&!visited.contains(new Node(first.x-2,first.y-1))){
                queue.add(new Node(first.x-2,first.y-1,distance));
            }
            if(first.x+2<=N&&first.y-1>0&&!visited.contains(new Node(first.x+2,first.y-1))){
                queue.add(new Node(first.x+2,first.y-1,distance));
            }
            if(first.x-2>0&&first.y+1<=N&&!visited.contains(new Node(first.x-2,first.y+1))){
                queue.add(new Node(first.x-2,first.y+1,distance));
            }
            if(first.x+2>0&&first.y+1<=N&&!visited.contains(new Node(first.x+2,first.y+1))){
                queue.add(new Node(first.x+2,first.y+1,distance));
            }
            if(first.x-1>0&&first.y-2>0&&!visited.contains(new Node(first.x-1,first.y-2))){
                queue.add(new Node(first.x-1,first.y-2,distance));
            }
            if(first.x-1>0&&first.y+2<=N&&!visited.contains(new Node(first.x-1,first.y+2))){
                queue.add(new Node(first.x-1,first.y+2,distance));
            }
            if(first.x+1<=N&&first.y-2>0&&!visited.contains(new Node(first.x+1,first.y-2))){
                queue.add(new Node(first.x+1,first.y-2,distance));
            }
            if(first.x+1<=N&&first.y+2<=N&&!visited.contains(new Node(first.x+1,first.y+2))){
                queue.add(new Node(first.x+1,first.y+2,distance));
            }
        }
        
        return answer;
    }


    int[][] moves={{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public int minStepToReachTargetV2(int KnightPos[], int TargetPos[], int N)
    {
        Queue<int[]> queue=new LinkedList<>();
        KnightPos[0]= KnightPos[0]-1;
        KnightPos[1]= KnightPos[1]-1;
        TargetPos[0]=TargetPos[0]-1;
        TargetPos[1]=TargetPos[1]-1;
        queue.add(KnightPos);
        int[] temp={-1,-1};
        queue.add(temp);
        int distance=0;
        boolean[][] visited=new boolean[N][N];
        while (!queue.isEmpty()){
            int[] front=queue.poll();
            if(front==temp){
                distance++;
                queue.add(temp);
                continue;
            }
            if(front==TargetPos){
                break;
            }
            if(visited[front[0]][front[1]]){
                continue;
            }
            visited[front[0]][front[1]]=true;
            for(int index=0;index< moves.length;index++){
                int i=front[0]+moves[index][0];
                int j=front[1]+moves[index][1];
                if(validate(i,j,N)){
                    queue.add(new int[]{i,j});
                }
            }
            
        }
        return distance;
    }

    private boolean validate(int i, int j,int N) {
        if(i<0||j<0||i>=N||j>=N){
            return false;
        }
        return true;
    }

}
