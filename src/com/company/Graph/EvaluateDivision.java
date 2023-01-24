package com.company.Graph;

import com.company.Graph.minimumSwaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/evaluate-division/description/
*/
public class EvaluateDivision {


    static boolean isAnswer = false;

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("x1", "x2"), Arrays.asList("x2", "x3"),
                Arrays.asList("x3", "x4"), Arrays.asList("x4", "x5"));
        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("x2", "x4"));
        calcEquation(equations, values, queries);
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            double answer = 1;
            boolean[] visited = new boolean[values.length];
            answer = func(visited, equations, values, queries.get(i).get(0), queries.get(i).get(1), 1d);
            answers[i] = answer;
        }
        return answers;
    }

    public static double func(boolean[] visited, List<List<String>> equations, double[] values, String src, String dest, double answer) {
        for (int i = 0; i < equations.size(); i++) {
            if (visited[i]) {
                continue;
            }
            if ((equations.get(i).get(0).equals(src) || equations.get(i).get(1).equals(src)) && src.equals(dest)) {
                return answer;
            } else if (equations.get(i).get(0).equals(src) && equations.get(i).get(1).equals(dest)) {
                answer = answer * values[i];
                return answer;
            } else if (equations.get(i).get(0).equals(dest) && equations.get(i).get(1).equals(src)) {
                answer = answer / values[i];
                return answer;
            } else if (equations.get(i).get(0).equals(src)) {
                visited[i] = true;
                double ans=func(visited, equations, values, equations.get(i).get(1), dest, answer * values[i]);
                if(ans!=-1){
                    return ans;
                }
            } else if (equations.get(i).get(1).equals(src)) {
                visited[i] = true;
                double ans= func(visited, equations, values, equations.get(i).get(0), dest,answer / values[i]);
                if(ans!=-1){
                    return ans;
                }
            }
        }
        return -1;
    }
}
