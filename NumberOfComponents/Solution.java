package NumberOfComponents;
import java.util.*;
class Solution {

  private void bfs(int node, int V, List<List<Integer>> adj, List<Boolean> visited){
    Queue<Integer> qu= new LinkedList<>();
    visited.set(node, true);
    qu.add(node);

    while(!qu.isEmpty()){
      int curNode=qu.poll();
      for(int neighbour: adj.get(curNode)){
        if(!visited.get(neighbour)) {
          qu.add(neighbour);
          visited.set(neighbour, true);
        }
      }
    }
  }
  public int findNumberOfComponent(int V, List<List<Integer>> edges) {


    // create adjacency List
    List<List<Integer>> adj= new ArrayList<>(Collections.nCopies(V, null));
    for(int i=0; i<V; i++){
      adj.set(i, new ArrayList<>());
    }

    for(int i=0; i<edges.size(); i++){
      adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
      adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
    }

    int numComponents=0; 
    List<Boolean> visited= new ArrayList<>(Collections.nCopies(V, false));
    for(int i=0; i<V; i++){
      if(!visited.get(i)){
        numComponents++;
        bfs(i, V, adj, visited);
      }
    }

    return numComponents;
  }
}

