package com.dsa.showcase.year2025.graph.dfs;

import java.util.*;

class AllPathFromSource {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> temp = new ArrayDeque<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //dfs to to traverse all path
        dfs(graph,0,graph.length-1);
        return result;
    }
    public void dfs(int[][]graph, int source, int destination){
        temp.add(source); 

        //check node is n-1
        if(source==destination){
            result.add(new ArrayList<>(temp));
        }
        else{
            for(int adj : graph[source]){
                dfs(graph,adj,destination);
            }
        }
        temp.removeLast();
    }
}