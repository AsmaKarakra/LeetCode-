
import java.util.*;

/**

Time: O(E) where E is the number of edges in the graph

Space: O(V) Vertices within the graph 

**/

public class Playground {

    public static HashMap<String, HashSet<String>> graph = new HashMap<>();


    public static void main(String[] args) {

        /**
         Compute Shortest Path:

         Write a function, shortestPath, that takes in a vector of edges for an
         undirected graph and two nodes (nodeA, nodeB). The function should return
         the length of the shortest path between A and B.
         Consider the length as the number of edges in the path, not the number of nodes.
         If there is no path between A and B, then return -1.
         */

       //Edge list:

        String [][] edges = {
                {"w", "x"},
                {"x", "y"},
                {"z", "y"},
                {"z", "v"},
                {"w", "v"}
        };

        int vertices = edges.length; //Number of nodes in the graph

        createGraph(edges, vertices);
        int result = findShortestPath("w", "z");

        System.out.println(result);
    }

    public static void createGraph(String[][] edges, int V){

        for(int i = 0; i<V; i++){

            if(!graph.containsKey(edges[i][0])){
                graph.put(edges[i][0], new HashSet<String>());
            }
            graph.get(edges[i][0]).add(edges[i][1]);


            if(!graph.containsKey(edges[i][1])){
                graph.put(edges[i][1], new HashSet<String>());
            }
            graph.get(edges[i][1]).add(edges[i][0]);
        }

    }

    public static int findShortestPath(String start, String end){
        int pathCount = 0;
        HashSet<String> visited = new HashSet<>();

        //Queue for BFS

        Queue<String> shortestPathQueue = new LinkedList<>();
        shortestPathQueue.offer(start);

        while(!shortestPathQueue.isEmpty()){
            String currentNode = shortestPathQueue.poll();
            visited.add(currentNode);

            if(currentNode.equals(end)){
                return pathCount;
            }

            pathCount++;

            HashSet<String> neighbors = graph.get(currentNode);

            if(neighbors.size() == 0){
                continue;
            }

            for(String node: neighbors){

                //if already visited - dont add to queue

                if(visited.contains(node)){
                    continue;
                }

                shortestPathQueue.offer(node);
            }
        }

        return -1;
    }
}
