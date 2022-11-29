import java.util.*;

/* Q1) Say we had |V|-1 edges picked from a connected, weighted, and undirected graph. Are we
    guaranteed that these edges form a MST? Why or why not?
 * No, we can't gurantee that these edges form a MST, because the sum of the 
 * |v|-1 edges might be greater than the MST weight. There's no restriction on
 * which edge to choose.  
 */

 /* Q2 */
public class HW5{
    public static void main(String[] args) {
        //test case 
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
                             
        System.out.println("Minimum cost: " + minCost(points));
    } 
//implmenting prim's algorithm
    public static int minCost(int [][] points) {
        int n = points.length, answer = 0; 
        HashSet<Integer> mst = new HashSet<>(); //creating a minimum spaning tree 
        mst.add(0); 
        int [] distance = new int[n]; 

        for(int i = 1; i<n; i++){ //find distance of each node
            distance[i] = findDistance (points, 0,i); 
        }

        while(mst.size() < n){ //find node w/ shortest distance
            int next = -1; 
            for(int i = 0; i <n; i++){
                if(mst.contains(i)) 
                    continue; 
                if(next == -1 || distance[next] > distance[i]) 
                    next = i;
            }
            //add node to mst
            mst.add(next);
            answer += distance[next]; 
            
            //update the distance array
            for(int i = 0;i<n;i++){
                if(!mst.contains(i)){
                    distance[i] = Math.min(distance[i], findDistance(points, i, next));
                }
            } 
        }
        return answer; 
    }
    //Calculate Manhatten Distance
    public static int findDistance(int [][] points, int a, int b){
        return Math.abs(points[a][0] - points [b][0]) + Math.abs(points[a][1] - points[b][1]);
    }

}

