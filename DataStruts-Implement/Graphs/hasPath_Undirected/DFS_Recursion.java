
public class Playground {

    public static HashMap<Character, HashSet<Character>> graph = new HashMap<>();

    public static void main(String[] args) {

        //graph using chars

        /**
         *
         * Problem: Undirected path between edge list
         *
         * for undirected graphs - used visited array

         edges: [

         [i,j],
         [k, i],
         [m, k],
         [k,l],
         [o,n],


         -- We want to convert edge list to adjacency list for better traversal algo

         */


        char[][] edges = {
                {'i', 'j'},
                {'k', 'i'},
                {'m', 'k'},
                {'k', 'l'},
                {'o', 'n'}
        };

        //Construct graph same size as out edges
        for (int i = 0; i < edges.length; i++) {
            graph.put(edges[i][0], new HashSet<Character>());
            graph.put(edges[i][1], new HashSet<Character>());
        }

        //Add edges within graph
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean result_1 = findPath('k', 'o');
        boolean result_2 = findPath('i', 'l');


        System.out.println(result_1);
        System.out.println(result_2);


    }

    public static boolean findPath(char src, char dest) {

        //DFS Implementation -- Time: O(E) E = edges in the graph || Space: O(N) N is the nodes in the graph

        Set<Character> visited = new HashSet<>();

        return findPathUtil(src, dest, visited);
    }

    public static boolean findPathUtil(char src, char dest, Set<Character> visited) {

        if (src == dest) {
            return true;
        }

        HashSet<Character> nodes = graph.get(src);
        for (Character node : nodes) {
            if (!visited.contains(node)) {
                visited.add(node);
                boolean result = findPathUtil(node, dest, visited);
                if (result == true) {
                    return result;
                }
            }

        }
        return false;
    }
}
