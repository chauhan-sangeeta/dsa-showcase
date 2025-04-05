package codemaze.graph.dfs;

import java.util.ArrayList;
import java.util.List;

class AllPathFromSource {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
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