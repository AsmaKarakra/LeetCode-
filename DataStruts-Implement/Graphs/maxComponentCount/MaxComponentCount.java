
public class Playground {

    public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int count = 0;
    static int maxCount = 0;

    public static void main(String[] args) {

        for(int i =0; i<9; i++){
            graph.put(i, new HashSet<Integer>());
        }


        boolean added = Collections.addAll(graph.get(0), 8, 1, 5);
        boolean added1 = Collections.addAll(graph.get(5), 0, 8);
        boolean added2 = Collections.addAll(graph.get(8), 0, 5);
        boolean added3 = Collections.addAll(graph.get(2), 3, 4);
        boolean added4 = Collections.addAll(graph.get(3), 2, 4);
        boolean added5 = Collections.addAll(graph.get(4), 3, 2);


        /**

         Write a function, largestComponent, that takes in an unordered_map representing
         the adjacency list of an undirected graph.

         The function should return the size of the largest connected component in the graph.

         graph = {

         0: [8, 1, 5],
         1: [0],
         5: [0, 8],
         8: [0, 5],
         2: [3, 4],
         3: [2, 4],
         4: [3, 2],

         }

         */

        int result = countConnectedComponents();
        System.out.println(result);

    }

    public static int countConnectedComponents(){

        HashSet<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, HashSet<Integer>> entry: graph.entrySet()) {

            boolean newComp = DFS(visited, entry.getKey());

         
            if (newComp == true) {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return maxCount;

        //Output should be 4
    }

    public static boolean  DFS(HashSet<Integer> visited, int key){
        //If already explored a component return false
        if(visited.contains(key)){
            return false;
        }

        //If new component was explored, incremenet count
        count++;

        visited.add(key);
        HashSet<Integer> nodes = graph.get(key);
        for(int node: nodes){
            DFS(visited, node);

        }
    return true;

    }
}
