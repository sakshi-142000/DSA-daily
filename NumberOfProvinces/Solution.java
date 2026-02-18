package NumberOfProvinces;
import java.util.*;
class Solution {

    private void dfs(int node, int n,List<List<Integer>> adj, List<Boolean> visited){
        visited.set(node, true);

        for(int neighbour: adj.get(node)){
            if(!visited.get(neighbour)) {
                dfs(neighbour, n, adj, visited);
            }
        }
        return;
    }
    public int numProvinces(int[][] adj) {
        int n=adj.length;
        List<List<Integer>> adjList= new ArrayList<>(Collections.nCopies(n, null));
        for(int i=0; i<n; i++){
            adjList.set(i, new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(adj[i][j]==1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
                
            }
        }

        List<Boolean> visited= new ArrayList<>(Collections.nCopies(n, false));
        int numProvinces=0;
        for(int i=0; i<n; i++){
            if(!visited.get(i)){
                numProvinces++;
                dfs(i, n, adjList, visited);
            }
        }

        return numProvinces;
    }
}


