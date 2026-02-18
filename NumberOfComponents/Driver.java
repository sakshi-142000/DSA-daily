package NumberOfComponents;
import java.util.*;


public class Driver {
    public static void main(String[] args){
        int V=4;
        List<List<Integer>> edges=Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2));

        Solution sol=new Solution();
        int ans=sol.findNumberOfComponent(V, edges);
        System.out.println("Number of components are: "+ ans);
    }
}
