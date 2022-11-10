import java.util.*;
import java.io.*;

public class Graph {
    public int [][] matrix; 
    public int vertices; 

    public Graph(int v) {
        vertices = v; 
        matrix = new int [v][v]; 

        for(int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                matrix[i][j] = 0; 
            }
        }
    }

    public void addEdge(int u, int v) {
        matrix[u][v] = 1; 
    }

    public static void DFSUtil(Graph graph, int v, int[] visited) {
        System.out.print(v + " ");
        visited[v] = 1; 

        for(int i = 0; i<graph.vertices; i++){
            if(graph.matrix[v][i] == 1 && visited[i] != 1){
                DFSUtil(graph, i, visited);
            }
        }
       
    }

    public static void DFS(Graph graph, int s) {
        int [] visited = new int [graph.vertices]; 
        
        for(int i =0; i<graph.vertices; i++){
            visited[i] = 0; 
        }
        DFSUtil(graph, s, visited);

        for(int i = 0; i < graph.vertices; i++){
            if(visited[i] != 1){
                DFSUtil(graph, i, visited);
            }
        }
        System.out.println(); 
    }

    

    public static void main(String[] args){
       
        Graph graph = new Graph(5); 
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(3, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);

        DFS(graph,  0);   // one possible output likes   0 
        DFS(graph,  1);  //  one possible output likes   1  0  2 4 3
        DFS(graph,  2);  // …
        DFS(graph,  3);  // …
        DFS(graph,  4);  // …

    }


}