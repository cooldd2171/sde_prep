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
    
}
