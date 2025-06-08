package com.dsa.showcase.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*802. Find Eventual Safe States
Solved
        Medium
Topics
        Companies
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.



Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.


Constraints:

n == graph.length
1 <= n <= 104
        0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].*/

public class FindEventualSafeNode {
    public static void main(String[] args){
        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        FindEventualSafeNode findEventualSafeNode = new FindEventualSafeNode();
        System.out.println(findEventualSafeNode.eventualSafeNodes(graph));
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj =new ArrayList();
        int []inDegree =new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int neighbor:graph[i]){
                adj.get(neighbor).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue =new LinkedList<>();
        //count node which has inDegree has zero
         for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        boolean []safe=new boolean[n];
        
        //traverse queue
        while(!queue.isEmpty()){
            int node=queue.remove();
            safe[node]=true;
            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}