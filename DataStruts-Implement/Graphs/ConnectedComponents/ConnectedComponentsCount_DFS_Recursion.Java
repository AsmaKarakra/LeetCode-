/**

Time: O(E) E = edges on graph

Space: O(V) V = vertices in the call stack

**/


public class Playground {

    public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) {

        /**

         Construct the following graph:

         Undirected graph

         graph: {
            3: [],
            4: [6],
            6: [4, 5, 7, 8],
            8: [6],
            7: [6],
            5: [6],
            1: [2],
            2: [1]
         }

         1 and 2 are connected

         4,5,7,8 are connected to 6 like a star

         3 is not connected to anything

         */


        for(int i =0; i<9; i++){
            graph.put(i, new HashSet<Integer>());
        }

        graph.get(4).add(6);
        boolean added = Collections.addAll(graph.get(6), 4, 5, 7, 8);
        graph.get(8).add(6);
        graph.get(7).add(6);
        graph.get(5).add(6);
        graph.get(1).add(2);
        graph.get(2).add(1);

        /**

         Write a function, connected_components_count, that takes in the adjacency list of an undirected graph.
         The function should return the number of connected components within the graph.

         */

        int result = countConnectedComponents();
        System.out.println(result);

    }

    public static int countConnectedComponents(){

        /**

         - Iterate through nodes in graph
         - Do DFS on node
         - Continue Traversal as far as possible
         - Increment Count once all nodes in our component have been visited
         - Return count

         */

        HashSet<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, HashSet<Integer>> entry: graph.entrySet()) {

            boolean newComp = DFS(visited, entry.getKey());

            //If new component was explored, incremenet count
            if (newComp == true) {
                count++;
            }
        }
        return count;

        //Output should be 4 
    }

    public static boolean  DFS(HashSet<Integer> visited, int key){

        //If already explored a component return false
        if(visited.contains(key)){
            return false;
        }

        visited.add(key);
        HashSet<Integer> nodes = graph.get(key);
        for(int node: nodes){

            DFS(visited, node);
        }
    return true;

    }
}
