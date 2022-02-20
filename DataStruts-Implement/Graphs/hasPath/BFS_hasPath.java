
public class Playground {

    public static HashMap<Character, List<Character>> graph = new HashMap<>();

    public static void main(String[] args){

        //graph using chars

        /**
         *
         * Problem: Directed Acyclic Graph
         * Determine if path exists from f to k
         *
         */

        graph.put('f', Arrays.asList('g','i'));
        graph.put('g', Arrays.asList('h'));
        graph.put('h', Arrays.asList());
        graph.put('i', Arrays.asList('g', 'k'));
        graph.put('j', Arrays.asList('i'));
        graph.put('k', Arrays.asList());

        boolean result = findPath(graph, 'f', 'k');
        System.out.println(result);


    }

    public static boolean findPath(HashMap<Character, List<Character>> graph, char src, char dest){

        //BFS Implementation -- Time: O(E) E = edges in the graph || Space: O(N) N is the nodes in the graph

        Queue<Character> BFS_queue = new LinkedList<>();

        BFS_queue.offer(src);

        while(!BFS_queue.isEmpty()){
            char currentNode = BFS_queue.poll();
            if(currentNode == dest){
                return true;
            }
            List<Character> neighbors = graph.get(currentNode);

            for(Character node: neighbors){
                BFS_queue.offer(node);
            }
        }
        return false;
    }
}
