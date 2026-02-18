package GraphTraversal;
import java.util.*;

class MySolution {

    private void dfsHelper(int node, List<List<Integer>> adj, List<Boolean> visited, 
    List<Integer> ans){

        ans.add(node);
        visited.set(node, true);
        for(int neighbour: adj.get(node)){
            if(!visited.get(neighbour)){
                dfsHelper(neighbour, adj, visited, ans);
            }
        }
    }

    public List<Integer> dfs(List<List<Integer>> adj, int nodes){
        List<Integer> ans= new ArrayList<>();
        List<Boolean> visited= new ArrayList(Collections.nCopies(nodes, false));

        for(int i=0; i<nodes; i++){
            if(!visited.get(i)){
                dfsHelper(i, adj, visited, ans);
            }
        }

        return ans;
    }

    private void bfsHelper(int node, List<List<Integer>> adj, List<Boolean> visited, 
    List<Integer> ans, int nodes){
        
        Queue<Integer> queue= new LinkedList<>();
        queue.add(node);

        visited.set(node, true);

        while(!queue.isEmpty()){
            int current=queue.poll();
            ans.add(current);

            for(int neighbour: adj.get(current)){
                if(!visited.get(neighbour)){
                    visited.set(neighbour, true);
                    queue.add(neighbour);
                }
            }
        }
    }

    public List<Integer> bfs(List<List<Integer>> adj, int nodes){
        List<Integer> ans= new ArrayList<>();

        List<Boolean> visited= new ArrayList<>(Collections.nCopies(nodes, false));

        for(int i=0; i<nodes; i++){
            if(!visited.get(i)) {
                bfsHelper(i, adj, visited, ans, nodes);
            }
        }
        return ans;
    }
    
}

class DriverTraversal{
    public static void main(String[] args){
        int v=5; //number of vertices
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());

        }

        adj.get(0).addAll(Arrays.asList(2, 3, 1));
        adj.get(1).addAll(Arrays.asList(0));
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).addAll(Arrays.asList(0));
        adj.get(4).addAll(Arrays.asList(2));

        
        MySolution sol= new MySolution();
        List<Integer> bfsAns=sol.bfs(adj, v);
        List<Integer> dfsAns=sol.dfs(adj, v);
        System.out.println("bfs traversal: "+ bfsAns);
        System.out.println("dfs traversal: "+ dfsAns);
    }
}
