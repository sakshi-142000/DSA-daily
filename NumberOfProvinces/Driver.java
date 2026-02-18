package NumberOfProvinces;
public class Driver {

public static void main(String[] args){
    int[][] adj = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {1, 0, 0, 1}
        };
     
        Solution sol= new Solution();
        int ans=sol.numProvinces(adj);

        System.out.println("Number of provinces: "+ ans);
}
    
}
